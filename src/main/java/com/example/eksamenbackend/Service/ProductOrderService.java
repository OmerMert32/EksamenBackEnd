package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Entity.ProductOrder;
import com.example.eksamenbackend.Repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService {

    @Autowired
    ProductOrderRepository productOrderRepository;

    public void save(ProductOrder productOrder){
        productOrderRepository.save(productOrder);
    }

}
