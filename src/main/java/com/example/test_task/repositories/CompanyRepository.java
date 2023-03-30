package com.example.test_task.repositories;

import com.example.test_task.models.Company;
import com.example.test_task.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findByPerson(Person person);

    @Query(value = "select*from companies where number like %?1",nativeQuery = true)
    List<Company> findByNumber(String number);
}
