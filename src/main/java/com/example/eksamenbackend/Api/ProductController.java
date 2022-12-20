package com.example.eksamenbackend.Api;

import com.example.eksamenbackend.Dto.Request.ProductRequest;
import com.example.eksamenbackend.Dto.Response.ProductResponse;
import com.example.eksamenbackend.Entity.Product;
import com.example.eksamenbackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductResponse> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{name}")
    public ProductResponse getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @GetMapping("/s/{name}")
    public List<ProductResponse> getProductsByName(@PathVariable String name){
        return productService.getProductsByName(name);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductRequest request){
        Product newProduct = new Product(request);
        productService.save(newProduct);
    }

    @DeleteMapping("/{name}")
    public void deleteProduct(@PathVariable String name){
        productService.deleteByName(name);
    }

    @PatchMapping("/{name}")
    public void updateProduct(@PathVariable String name, @RequestBody ProductRequest pr){
        productService.updateProduct(name, pr);
    }
}
