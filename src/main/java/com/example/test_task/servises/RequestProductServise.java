package com.example.test_task.servises;

import com.example.test_task.models.RequestProduct;
import com.example.test_task.repositories.RequestProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RequestProductServise {

    private final RequestProductsRepository requestProductsRepository;

    @Autowired
    public RequestProductServise(RequestProductsRepository requestProductsRepository) {
        this.requestProductsRepository = requestProductsRepository;
    }

    public List<RequestProduct> getAllRequestProducts(){
        return requestProductsRepository.findAll();
    }
}
