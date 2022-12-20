package com.example.eksamenbackend.Repository;

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
class DeliveryRepositoryTest {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductOrderRepository productOrderRepository;

    @BeforeEach
    void setUpB4Each() {
        Product kakao = new Product("Kakao", 32, 400);
        productRepository.save(kakao);

        ProductOrder productOrder = new ProductOrder(2, kakao);
        productOrderRepository.save(productOrder);

        List<ProductOrder> productOrders = new ArrayList<>();
        productOrders.add(productOrder);

        Delivery delivery = new Delivery("Varehus 1", "Ömer, Grønvej 10", productOrders);
        deliveryRepository.save(delivery);
    }

    @Test
    void findByDestinationContaining() {
        String actual = deliveryRepository.findByDestinationContaining("Ömer").getDestination();
        assertEquals("Ömer, Grønvej 10", actual);
    }

}