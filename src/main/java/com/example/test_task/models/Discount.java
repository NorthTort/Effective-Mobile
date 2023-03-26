package com.example.test_task.models;



import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "discount")
    private List<Product> products;

    @Column(name = "value")
    @NotEmpty(message = "Размер скидки не может быть пустым")
    @Min(value = 0, message = "Скидка на товар не может быть отрицательной")
    @Max(value = 99, message = "Cкидка на товар не может быть 100%")
    private byte value;

    @NotEmpty(message = "Время скидки не может быть пустым")
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
