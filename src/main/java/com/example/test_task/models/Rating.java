package com.example.test_task.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(optional = false)
    private Person person;

    @ManyToOne(optional = false)
    private Product product;

    @Column(name = "rating", nullable = false)
    @Min(value = 1, message = "Оценка товара не может быть отрицательным или ноль")
    @Max(value = 5, message = "Оценка товара не может быть больше пяти")
    @NotNull(message = "Оценка товара не может быть отрицательным или пустым")
    private short rating;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public short getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }
}
