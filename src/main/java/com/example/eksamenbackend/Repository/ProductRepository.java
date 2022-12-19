package com.example.eksamenbackend.Repository;

import com.example.eksamenbackend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByNameContaining(String name);
}
