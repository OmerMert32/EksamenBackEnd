package com.example.eksamenbackend.Repository;

import com.example.eksamenbackend.Entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

}
