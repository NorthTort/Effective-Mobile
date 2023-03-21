package com.example.test_task.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false, columnDefinition = "text", unique = true)
    @NotEmpty(message = "Название организации не может быть пустым")
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "text")
    @NotEmpty(message = "Описание организации не может быть пустым")
    private String description;

    @OneToOne
    @JoinColumn(name = "logo_id")
    private Image logo;

    @OneToMany(mappedBy = "company")
    private List<Product> products;

    private LocalDateTime dateTimeOfCreate;

    public Company() {
    }

    public Company(String title, String description) {
        this.title = title;
        this.description = description;
    }


    //Будет заполняться дата и время при создании объекта класса
    @PrePersist
    private void init(){
        dateTimeOfCreate = LocalDateTime.now();
    }

    public int getId() {
        return id;
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

    public List<Product> getProducts() {
        return products;
    }

    public LocalDateTime getDateTimeOfCreate() {
        return dateTimeOfCreate;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setDateTimeOfCreate(LocalDateTime dateTimeOfCreate) {
        this.dateTimeOfCreate = dateTimeOfCreate;
    }
}
