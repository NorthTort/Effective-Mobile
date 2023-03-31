package com.example.test_task.controllers;

import com.example.test_task.security.PersonDetails;
import com.example.test_task.servises.RequestCompaniesServise;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RequestCompaniesServise requestCompaniesServise;

    public AdminController(RequestCompaniesServise requestCompaniesServise) {
        this.requestCompaniesServise = requestCompaniesServise;
    }


    @GetMapping()
    public String admin(Model model){
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
}
