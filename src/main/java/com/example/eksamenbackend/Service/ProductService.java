package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Dto.Request.ProductRequest;
import com.example.eksamenbackend.Dto.Response.ProductResponse;
import com.example.eksamenbackend.Entity.Product;
import com.example.eksamenbackend.Repository.DeliveryRepository;
import com.example.eksamenbackend.Repository.ProductOrderRepository;
import com.example.eksamenbackend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductOrderRepository productOrderRepository;
    @Autowired
    DeliveryRepository deliveryRepository;

    public void save(Product product){
        productRepository.save(product);
    }


    public List<ProductResponse> getProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductResponse> responses = products.stream().map(p -> new ProductResponse(p)).collect(Collectors.toList());
        return responses;
    }

    public ProductResponse getProductByName(String name){
        Product found = productRepository.findByName(name);

        return new ProductResponse(found);
    }

    @Transactional
    public void deleteByName(String name){
        productRepository.deleteProductByName(name);
    }

    public void updateProduct(String name, ProductRequest pr){

        Product product = productRepository.findByNameContaining(name).get(0);
        product.setName(pr.getName());
        product.setPrice(pr.getPrice());
        product.setWeight(pr.getWeight());

        productRepository.save(product);
    }

    public List<ProductResponse> getProductsByName(String name){
        List<Product> products = productRepository.findByNameContaining(name);
        List<ProductResponse> responses = products.stream().map(p -> new ProductResponse(p)).collect(Collectors.toList());
        return responses;
    }
}
