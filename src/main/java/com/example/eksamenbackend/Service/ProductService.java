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

    public List<ProductResponse> getProductByName(String name){
        List<ProductResponse> responses = new ArrayList<>();
        List<Product> found =  productRepository.findByNameContaining(name);
        responses = found.stream().map(p -> new ProductResponse(p)).collect(Collectors.toList());

        return responses;
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

    public void updateProduct(int id, ProductRequest pr){

        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().setName(pr.getName());
            product.get().setPrice(pr.getPrice());
            product.get().setWeight(pr.getWeight());

            productRepository.save(product.get());
        }
    }
}
