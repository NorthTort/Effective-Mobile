package com.example.test_task.repositories;

import com.example.test_task.models.Notification;
import com.example.test_task.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    List<Notification> findByPerson(Person person);

    @Query(value = "select * from notifications where number like %?1", nativeQuery = true)
    List<Notification> findByNumber(String number);

}
