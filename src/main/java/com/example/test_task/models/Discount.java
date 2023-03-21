package com.example.test_task.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.List;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "company")
    private List<Product> products;

    @Column(name = "value")
    @Min(value = 0, message = "Скидка на товар не может быть отрицательной")
    @Max(value = 99, message = "Cкидка на товар не может быть 100%")
    private byte value;

    @Column(name = "time")
    private LocalTime time;

    public Discount() {
    }

    public Discount(byte value, LocalTime time) {
        this.value = value;
        this.time = time;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
