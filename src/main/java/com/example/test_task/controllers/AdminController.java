package com.example.test_task.controllers;

import com.example.test_task.models.Notification;
import com.example.test_task.repositories.PersonRepository;
import com.example.test_task.repositories.ProductRepository;
import com.example.test_task.security.PersonDetails;
import com.example.test_task.servises.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RequestCompaniesServise requestCompaniesServise;
    private final RequestProductServise requestProductServise;
    private final PersonRepository personRepository;
    private final NotificationServise notificationServise;
    private final PersonServise personServise;
    private final CompanyServise companyServise;
    private final ProductServise productServise;


    public AdminController(RequestCompaniesServise requestCompaniesServise, RequestProductServise requestProductServise,
                           PersonRepository personRepository, NotificationServise notificationServise, PersonServise personServise, CompanyServise companyServise, ProductServise productServise) {
        this.requestCompaniesServise = requestCompaniesServise;
        this.requestProductServise = requestProductServise;
        this.personRepository = personRepository;
        this.notificationServise = notificationServise;
        this.personServise = personServise;
        this.companyServise = companyServise;
        this.productServise = productServise;
    }


    @GetMapping()
    public String admin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        String role = personDetails.getPerson().getRole();

        if(role.equals("ROLE_USER")){
            return "redirect:/index";
        }

        return "admin/admin";
    }

    @GetMapping("/requestCompanies")
    public String requestCompaniesAdmin(Model model){
        model.addAttribute("requestCompanies",requestCompaniesServise.getAllRequestCompanies());
        return  "admin/requestCompanies";
    }

    @GetMapping("/requestProducts")
    public String requestProductAdmin(Model model){
        model.addAttribute("requestProducts",requestProductServise.getAllRequestProducts());
        return "admin/requestProducts";
    }

    @GetMapping("/person/send/{id}")
    public String sendPerson(Model model){
        model.addAttribute("notification", new Notification());
        model.addAttribute("person", personRepository.findAll());
        return "admin/sendNotification";
    }

    @PostMapping("/person/send/{id}")
    public String sendPerson(@ModelAttribute("notification") @Valid Notification notification){
        notificationServise.saveNotification(notification);
        return "redirect:/admin/sendNotification";
    }

    @GetMapping("/users")
    public String usersAdmin(Model model){
        model.addAttribute("users", personServise.getAllPerson());
        return "admin/users";
    }

    @GetMapping("/companies")
    public String companiesAdmin(Model model){
        model.addAttribute("companies", companyServise.getAllCompany());
        return "admin/companies";
    }

    @GetMapping("/company/{id}")
    public String companyAdmin(@PathVariable("id") int id, Model model){
        model.addAttribute("company", companyServise.getCompanyId(id));
        model.addAttribute("products", productServise.getAllProductCompanyId(id));
        return "admin/company";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("editProduct", productServise.getProductId(id));
        return "admin/product";
    }


}
