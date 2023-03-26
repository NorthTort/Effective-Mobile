package com.example.test_task.repositories;

import com.example.test_task.enumm.Status;
import com.example.test_task.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByTitle(String title);

    @Query(value = "select product.id, product.title, product.description, product.company, product.price, product.quantity, product.feedback, product.keywords, product.characteristics, product.ratings from product inner join company on product.company = company.id where company.status = 'Active'", nativeQuery = true)
    List<Product> findByCompanyActive();


}
