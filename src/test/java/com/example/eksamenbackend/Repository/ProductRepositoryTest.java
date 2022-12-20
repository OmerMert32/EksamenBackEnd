package com.example.eksamenbackend.Repository;

import com.example.eksamenbackend.Entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setUpB4Each() {
        Product kakao = new Product("Kakao", 32, 400);
        productRepository.save(kakao);

    }
    @Test
    void deleteByName() {
        productRepository.deleteByName("Kakao");

        assertEquals(0, productRepository.findAll().size());
    }
    @Test
    void findByNameContaining(){
        List<Product> products = productRepository.findByNameContaining("k");
        assertEquals(1, products.size());
    }
}