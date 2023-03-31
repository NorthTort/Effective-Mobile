package com.example.test_task.servises;

import com.example.test_task.models.RequestCompany;
import com.example.test_task.repositories.RequestCompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RequestCompaniesServise {

    private final RequestCompaniesRepository requestCompaniesRepository;

    @Autowired
    public RequestCompaniesServise(RequestCompaniesRepository requestCompaniesRepository) {
        this.requestCompaniesRepository = requestCompaniesRepository;
    }

    public List<RequestCompany> getAllRequestCompanies(){
        return requestCompaniesRepository.findAll();
    }
}
