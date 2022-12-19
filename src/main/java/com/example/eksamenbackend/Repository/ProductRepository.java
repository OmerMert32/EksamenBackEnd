package com.example.eksamenbackend.Repository;

import com.example.eksamenbackend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
