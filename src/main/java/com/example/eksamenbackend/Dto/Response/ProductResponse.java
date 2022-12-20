package com.example.eksamenbackend.Dto.Response;

import com.example.eksamenbackend.Entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {

    int id;
    String name;

    int price;

    int weight;


    public ProductResponse(Product p){
        this.id = p.getProductId();
        this.name = p.getName();
        this.price = p.getPrice();
        this.weight = p.getWeight();
    }
}
