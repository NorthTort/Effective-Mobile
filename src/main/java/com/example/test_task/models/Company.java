package com.example.test_task.models;



import com.example.test_task.enumm.Status;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @Column(name = "title", nullable = false, columnDefinition = "text", unique = true)
    @NotEmpty(message = "Название организации не может быть пустым")
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "text")
    @NotEmpty(message = "Описание организации не может быть пустым")
    private String description;

    @OneToOne
    @JoinColumn(name = "logo_id")
    private Image logo;

    @Column(name = "balance", nullable = false)
    @Min(value = 0, message = "Баланс не может быть отрицательным")
    @NotNull(message = "Баланс не может быть пустым")
    private float balance;

    @OneToMany(mappedBy = "company")
    private List<Product> products;

    private LocalDateTime dateTimeOfCreate;

    private Status status;

    public Company() {
    }

    public Company(String number, String title, String description, float balance) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.balance = balance;
        this.status = Status.Active;
    }


    //Будет заполняться дата и время при создании объекта класса
    @PrePersist
    private void init(){
        dateTimeOfCreate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Image getLogo() {
        return logo;
    }

    public float getBalance() {
        return balance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDateTime getDateTimeOfCreate() {
        return dateTimeOfCreate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setDateTimeOfCreate(LocalDateTime dateTimeOfCreate) {
        this.dateTimeOfCreate = dateTimeOfCreate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
