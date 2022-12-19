package com.example.eksamenbackend.Repository;

import com.example.eksamenbackend.Entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    List<Delivery> findByDestinationContaining(String value);
}
