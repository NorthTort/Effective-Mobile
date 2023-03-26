package com.example.test_task.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    private Person person;

    @ManyToOne(optional = false)
    private Product product;

    @Column(name = "feedback", nullable = false, columnDefinition = "text")
    @NotEmpty(message = "Отзыв о товаре не может быть пустым")
    private String feedback;

    public Feedback() {
    }

    public Feedback(String feedback) {
        this.feedback = feedback;
    }

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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
