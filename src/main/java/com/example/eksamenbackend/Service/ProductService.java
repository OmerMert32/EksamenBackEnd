package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Dto.Request.ProductRequest;
import com.example.eksamenbackend.Dto.Response.ProductResponse;
import com.example.eksamenbackend.Entity.Product;
import com.example.eksamenbackend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void save(Product product){
        productRepository.save(product);
    }


    public List<ProductResponse> getProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductResponse> responses = products.stream().map(p -> new ProductResponse(p)).collect(Collectors.toList());
        return responses;
    }

    public ProductResponse getProductByName(String name){
        Product found = productRepository.findByNameContaining(name);

        return new ProductResponse(found);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

    public void updateProduct(String name, ProductRequest pr){

        Product product = productRepository.findByNameContaining(name);
            product.setName(pr.getName());
            product.setPrice(pr.getPrice());
            product.setWeight(pr.getWeight());

            productRepository.save(product);
    }
}
