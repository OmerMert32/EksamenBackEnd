package com.example.eksamenbackend.Api;

import com.example.eksamenbackend.Dto.Request.DeliveryRequest;
import com.example.eksamenbackend.Dto.Response.DeliveryResponse;
import com.example.eksamenbackend.Entity.Delivery;
import com.example.eksamenbackend.Entity.ProductOrder;
import com.example.eksamenbackend.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
@CrossOrigin
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;


    @GetMapping
    public List<DeliveryResponse> getDeliveries(){
        return deliveryService.getDeliveries();
    }

    @GetMapping("/{destination}")
    public List<DeliveryResponse> getDeliveryByDestination(@PathVariable String destination){
        return deliveryService.findByDestinationContaining(destination);
    }

    @PostMapping
    public void addDelivery(@RequestBody DeliveryRequest request){
        Delivery newDelivery = new Delivery(request);
        deliveryService.save(newDelivery);
    }

    @PatchMapping("/{id}")
    public void addProductOrder(@PathVariable int id, @RequestBody ProductOrder productOrder){
        deliveryService.addProductOrder(id, productOrder);
    }
}
