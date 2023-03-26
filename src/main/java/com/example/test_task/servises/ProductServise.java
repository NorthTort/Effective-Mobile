package com.example.test_task.servises;

import java.util.List;
import java.util.Optional;
import com.example.test_task.models.Product;
import com.example.test_task.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProductServise {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServise(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public List<Product> getAllActiveProduct(){
        return productRepository.findByCompanyActive();
    }

    public Product getProductId(int id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Transactional
    public void saveProduct(Product product){
        productRepository.save(product);
    }
}
