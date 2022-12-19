package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Entity.Product;
import com.example.eksamenbackend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void save(Product product){
        productRepository.save(product);
    }

}
