package com.example.test_task.servises;

import com.example.test_task.models.Company;
import com.example.test_task.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CompanyServise {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServise(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }

    @Transactional
    public void saveCompany(Company company){
        companyRepository.save(company);
    }
}
