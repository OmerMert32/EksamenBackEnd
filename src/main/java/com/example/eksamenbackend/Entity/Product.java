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
@Table(name = "table_product")
@Getter
@Setter
public class Product {

    @Id
    int productId;

    String name;

    int price;

    int weight;

}
