package com.example.eksamenbackend.Repository;

import com.example.eksamenbackend.Entity.Product;
import com.example.eksamenbackend.Entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    List<ProductOrder> findByProductContaining(String name);

    void deleteByQuantityAndProduct(int quantity, Product product);
}
