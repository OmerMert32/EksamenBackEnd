package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Entity.Delivery;
import com.example.eksamenbackend.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    public void save(Delivery delivery){
        deliveryRepository.save(delivery);
    }

}
