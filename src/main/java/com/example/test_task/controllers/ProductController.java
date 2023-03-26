package com.example.test_task.controllers;

import com.example.test_task.repositories.ProductRepository;
import com.example.test_task.servises.ProductServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductServise productServise;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductServise productServise) {
        this.productRepository = productRepository;
        this.productServise = productServise;
    }

    @GetMapping("")
    public String getAllProduct(Model model){
        model.addAttribute("products", productServise.getAllActiveProduct());
        return "product/products";
    }
}
