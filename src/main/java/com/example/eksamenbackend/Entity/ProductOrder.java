package com.example.eksamenbackend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_orders")
@Getter
@Setter
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int quantity;

    @ManyToOne
    @JoinColumn(name = "products_product_id")
    Product product;


    public ProductOrder(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}


