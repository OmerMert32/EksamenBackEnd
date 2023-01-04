package com.example.eksamenbackend.Repository;
//
import com.example.eksamenbackend.Entity.Delivery;
import com.example.eksamenbackend.Entity.Product;
import com.example.eksamenbackend.Entity.ProductOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductOrderRepositoryTest {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductOrderRepository productOrderRepository;


    @Test
    void deleteByQuantityAndName(){
        Product kakao = new Product("Kakao", 32, 400);
        productRepository.save(kakao);

        ProductOrder productOrder = new ProductOrder(2, kakao);
        productOrderRepository.save(productOrder);

        productOrderRepository.deleteByQuantityAndProduct(2, kakao);

        assertEquals(0, productOrderRepository.findAll().size());
    }
}