package com.example.test_task.util;

import com.example.test_task.models.Product;
import com.example.test_task.servises.ProductServise;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import java.util.Set;

@Component
public class ProductValidator implements Validator {

    private final ProductServise productServise;

    public ProductValidator(ProductServise productServise) {
        this.productServise = productServise;
    }

    @Override
    public boolean supports(Class<?> clazz){
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        if(productServise.getProductFindByTitle(product) != null){
            errors.rejectValue("title","","Данное наименование товара уже используется");
        }
    }


}
