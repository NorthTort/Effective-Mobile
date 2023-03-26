package com.example.test_task.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Table(name = "requests_companys")
public class RequestCompany {

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

    private LocalDateTime dateTimeOfCreate;

    public RequestCompany() {
    }

    public RequestCompany(String title, String description, Image logo) {
        this.title = title;
        this.description = description;
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

    @PrePersist
    private void init(){
        dateTimeOfCreate = LocalDateTime.now();
    }
}
