package com.example.test_task.repositories;

import com.example.test_task.models.Person;
import com.example.test_task.models.RequestCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RequestCompaniesRepository extends JpaRepository<RequestCompany, Integer> {

    List<RequestCompany> findByPerson(Person person);

}
