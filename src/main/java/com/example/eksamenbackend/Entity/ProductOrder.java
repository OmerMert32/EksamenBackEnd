package com.example.eksamenbackend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_orders")
@Getter
@Setter
public class ProductOrder {

    @Id
    int id;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    Delivery delivery;

    @OneToMany
    @JoinColumn(name = "product_product_id")
    List<Product> products;
}
