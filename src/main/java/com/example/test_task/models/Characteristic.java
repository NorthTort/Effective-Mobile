package com.example.test_task.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false, columnDefinition = "text", unique = true)
    @NotEmpty(message = "Название характеристики не может быть пустым")
    private String title;

    @Column(name = "value", nullable = false, columnDefinition = "text")
    @NotEmpty(message = "Значение характеристики не может быть пустым")
    private String value;

    @ManyToOne(optional = false)
    private Product product;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
