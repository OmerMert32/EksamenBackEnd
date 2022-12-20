package com.example.eksamenbackend.Entity;

import com.example.eksamenbackend.Dto.Request.ProductRequest;
import com.example.eksamenbackend.Dto.Response.ProductResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PublicKey;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;

    String name;

    int price;

    int weight;

    public Product(ProductRequest request){
        this.name = request.getName();
        this.price = request.getPrice();
        this.weight = request.getWeight();
    }

    public Product(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Product(ProductResponse response){
        this.productId = response.getId();
        this.name = response.getName();
        this.price = response.getPrice();
        this.weight = response.getWeight();
    }
}
