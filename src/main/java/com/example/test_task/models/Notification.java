package com.example.test_task.models;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false) //Связь с пользователем, кто отправил сообщение
    private Person senderPerson;

    @ManyToOne(optional = false) //Связь с пользователем, кто принимает сообщение
    private Person recipientPerson;

    @NotEmpty(message = "Заголовок уведомления не может быть пустым")
    @Size(min = 1, max = 100, message = "Заголовок уведомления должен содержать от 1 до 100 символов")
    @Column(name = "notificationHeading", nullable = false, columnDefinition = "text")
    private String notificationHeading;

    @NotEmpty(message = "Уведомление не может быть пустым")
    @Size(min = 1, max = 500, message = "Уведомление должно содержать от 1 до 500 символов")
    @Column(name = "notificationText", nullable = false, columnDefinition = "text")
    private String notificationText;

    private LocalDateTime dateTime;

    public Notification() {
    }

    public Notification(String notificationText, String notificationHeading) {
        this.notificationText = notificationText;
        this.notificationHeading = notificationHeading;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotificationHeading() {
        return notificationHeading;
    }

    public void setNotificationHeading(String notificationHeading) {
        this.notificationHeading = notificationHeading;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @PrePersist
    private void init(){
        dateTime = LocalDateTime.now();
    }
}
