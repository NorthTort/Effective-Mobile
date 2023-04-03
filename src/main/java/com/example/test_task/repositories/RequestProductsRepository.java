package com.example.test_task.repositories;

import com.example.test_task.models.Company;
import com.example.test_task.models.RequestProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestProductsRepository extends JpaRepository<RequestProduct, Integer> {

    List<RequestProduct> findByCompany(Company company);
}
