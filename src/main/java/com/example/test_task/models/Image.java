package com.example.test_task.models;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fileName;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Image() {
    }
    public Image(String fileName, Company company) {
        this.fileName = fileName;
        this.company = company;
    }

    public String getFileName() {
        return fileName;
    }

    public Company getCompany() {
        return company;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
