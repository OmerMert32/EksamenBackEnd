package com.example.eksamenbackend.Repository;

import com.example.eksamenbackend.Entity.Delivery;
import com.example.eksamenbackend.Entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    Delivery findByDestinationContaining(String value);



    List<Delivery> deleteByProductOrderEquals(ProductOrder productOrder);

}
