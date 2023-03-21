package com.example.test_task.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "title", nullable = false, columnDefinition = "text", unique = true)
    @NotEmpty(message = "Название не может быть пустым")
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "text")
    @NotEmpty(message = "Описание товара не может быть пустым")
    private String description;

    @ManyToOne(optional = false)
    private Company company;

    @Column(name = "price", nullable = false)
    @Min(value = 1, message = "Цена товара не может быть отрицательной или 0")
    @NotNull(message = "Цена товара не может быть отрицательной или 0")
    private float price;

    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "Количество товара не может быть отрицательным")
    @NotNull(message = "Количество товара не может быть отрицательным или пустым")
    private int quantity;

    @ManyToOne(optional = false)
    private Discount discount;

    @OneToMany(mappedBy = "product")
    private List<Feedback> feedback;

    @Column(name = "keywords", nullable = false, columnDefinition = "text")
    @NotEmpty(message = "Ключевые слова товара не могут быть пустыми")
    private String keywords;

    private LocalDateTime dateTimeOfCreate;

    public Product() {
    }

    public Product(String title, String description, float price, int quantity, String keywords) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.keywords = keywords;
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

    public Company getCompany() {
        return company;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Discount getDiscount() {
        return discount;
    }

    public List<Feedback> getFeedback() {
        return feedback;
    }

    public String getKeywords() {
        return keywords;
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

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setDateTimeOfCreate(LocalDateTime dateTimeOfCreate) {
        this.dateTimeOfCreate = dateTimeOfCreate;
    }
}
