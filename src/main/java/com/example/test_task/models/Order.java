package com.example.test_task.models;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    private int count;
    private float price;

    private LocalDateTime dateTime;

    @ManyToOne(optional = false) //Связь с продуктом
    private Product product;

    @ManyToOne(optional = false) //Связь с пользователем, кто совершил заказ
    private Person person;

    public Order() {
    }

    public Order(String number, int count, float price, Product product, Person person) {
        this.number = number;
        this.count = count;
        this.price = price;
        this.product = product;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @PrePersist
    private void init(){
        dateTime = LocalDateTime.now();
    }
}
