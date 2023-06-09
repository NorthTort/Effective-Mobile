package com.example.test_task.controllers;

import com.example.test_task.models.Company;
import com.example.test_task.models.Notification;
import com.example.test_task.repositories.CompanyRepository;
import com.example.test_task.repositories.NotificationRepository;
import com.example.test_task.security.PersonDetails;
import com.example.test_task.servises.ProductServise;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final NotificationRepository notificationRepository;
    private final CompanyRepository companyRepository;
    private final ProductServise productServise;

    public UserController(NotificationRepository notificationRepository, CompanyRepository companyRepository, ProductServise productServise) {
        this.notificationRepository = notificationRepository;
        this.companyRepository = companyRepository;
        this.productServise = productServise;
    }

    @GetMapping("/index")
    public String index(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        String role = personDetails.getPerson().getRole();

        if(role.equals("ROLE_ADMIN")){
            return "redirect:/admin";
        }

        model.addAttribute("products", productServise.getAllActiveProduct());

        return "user/index";
    }


    @GetMapping("/notifications")
    public String notificationsUser(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        List<Notification> notificationList = notificationRepository.findByPerson(personDetails.getPerson());

        model.addAttribute("notifications",notificationList);
        return "/user/notifications";
    }

    @GetMapping("/companies")
    public String companiesUser(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        List<Company> companyList = companyRepository.findByPerson(personDetails.getPerson());

        model.addAttribute("companies",companyList);
        return "/user/companies";
    }



}
