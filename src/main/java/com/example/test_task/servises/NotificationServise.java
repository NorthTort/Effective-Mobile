package com.example.test_task.servises;

import com.example.test_task.models.Notification;
import com.example.test_task.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class NotificationServise {
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationServise(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAllNotification(){
        return notificationRepository.findAll();
    }

    public Notification getNotificationId(int id){
        Optional<Notification> optionalNotification = notificationRepository.findById(id);
        return optionalNotification.orElse(null);
    }

    @Transactional
    public void saveNotification(Notification notification){
        notificationRepository.save(notification);
    }
}
