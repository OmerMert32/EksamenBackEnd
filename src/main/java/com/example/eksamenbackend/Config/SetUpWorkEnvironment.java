package com.example.eksamenbackend.Config;

import com.example.eksamenbackend.Entity.Delivery;
import com.example.eksamenbackend.Entity.Product;
import com.example.eksamenbackend.Entity.ProductOrder;
import com.example.eksamenbackend.Service.DeliveryService;
import com.example.eksamenbackend.Service.ProductOrderService;
import com.example.eksamenbackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SetUpWorkEnvironment implements ApplicationRunner {

    @Autowired
    DeliveryService deliveryService;

    @Autowired
    ProductOrderService productOrderService;

    @Autowired
    ProductService productService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Product mælk = new Product("Mælk", 10, 1000);
        productService.save(mælk);

        Product proteinpulver = new Product("Proteinpulver", 180, 1000);
        productService.save(proteinpulver);


        ProductOrder productOrder = new ProductOrder(1, 2, mælk);
        productOrderService.save(productOrder);

        ProductOrder productOrder1 = new ProductOrder(2, 1, proteinpulver);
        productOrderService.save(productOrder1);

        List<ProductOrder> productOrders = new ArrayList<>();
        productOrders.add(productOrder);
        productOrders.add(productOrder1);


        Delivery delivery = new Delivery(LocalDateTime.now().plusDays(1), "W1", "Ömer Mert, Grønrisvej 4", productOrders);
        deliveryService.save(delivery);




    }
}

