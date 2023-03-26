package com.example.test_task.models;

import com.example.test_task.enumm.Status;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Логин не может быть пустым")
    @Size(min = 5, max = 20, message = "Логин должен быть от 5 до 20 символов")
    @Column(name = "login")
    private String login;

    @NotEmpty(message = "Почта не может быть пустой")
    @Column(name = "mail")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@\" \n" +
            "        + \"[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$", message = "Некорректный адрес электронной почты")
    private String mail;

    @NotEmpty(message = "Пароль не может быть пустым")
    @Column(name = "password")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "Строчные и прописные латинские буквы, цифры, спецсимволы. Минимум 8 символов")
    private String password;

    @Column(name = "balance", nullable = false)
    @Min(value = 0, message = "Баланс не может быть отрицательным")
    @NotNull(message = "Баланс не может быть пустым")
    private float balance;

    @Column(name = "role")
    private String role;

    private Status status;

    public Person() {
    }

    public Person(String login, String mail, String password, float balance) {
        this.login = login;
        this.mail = mail;
        this.password = password;
        this.balance = balance;
        this.status = Status.Active;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public float getBalance() {
        return balance;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
