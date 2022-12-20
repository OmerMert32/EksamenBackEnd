package com.example.eksamenbackend.Service;

import com.example.eksamenbackend.Dto.Response.DeliveryResponse;
import com.example.eksamenbackend.Entity.Delivery;
import com.example.eksamenbackend.Entity.ProductOrder;
import com.example.eksamenbackend.Repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    ProductOrderService productOrderService;

    public void save(Delivery delivery){
        deliveryRepository.save(delivery);
    }

    public List<DeliveryResponse> getDeliveries(){
        List<Delivery> deliveries = deliveryRepository.findAll();
        List<DeliveryResponse> responses = deliveries.stream().map(d -> new DeliveryResponse(d)).collect(Collectors.toList());

        return responses;
    }

    public void addProductOrder(int id, ProductOrder productOrder){
        productOrderService.save(productOrder);
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if (delivery.isPresent()) {
            delivery.get().setTotalPrice(delivery.get().getTotalPrice() + productOrder.getProduct().getPrice() * productOrder.getQuantity());
            delivery.get().setTotalWeight(delivery.get().getTotalWeight() + productOrder.getProduct().getWeight() * productOrder.getQuantity());
            delivery.get().getProductOrder().add(productOrder);
            deliveryRepository.save(delivery.get());
        }
    }

    public DeliveryResponse findByDestinationContaining(String value){

        Delivery delivery = deliveryRepository.findByDestinationContaining(value);

        return new DeliveryResponse(delivery);
    }
}
