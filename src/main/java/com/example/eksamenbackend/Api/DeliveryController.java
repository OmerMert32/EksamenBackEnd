package com.example.eksamenbackend.Api;

import com.example.eksamenbackend.Dto.Request.DeliveryRequest;
import com.example.eksamenbackend.Dto.Response.DeliveryResponse;
import com.example.eksamenbackend.Entity.Delivery;
import com.example.eksamenbackend.Entity.Product;
import com.example.eksamenbackend.Entity.ProductOrder;
import com.example.eksamenbackend.Service.DeliveryService;
import com.example.eksamenbackend.Service.ProductOrderService;
import com.example.eksamenbackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/delivery")
@CrossOrigin
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @Autowired
    ProductService productService;

    @Autowired
    ProductOrderService productOrderService;


    @GetMapping
    public List<DeliveryResponse> getDeliveries(){
        return deliveryService.getDeliveries();
    }

    @GetMapping("/{destination}")
    public DeliveryResponse getDeliveryByDestination(@PathVariable String destination){
        return deliveryService.findByDestinationContaining(destination);
    }

    @GetMapping("/s/{destination}")
    public List<DeliveryResponse> getDeliveriesByDestination(@PathVariable String destination){
        List<DeliveryResponse> deliveryResponses = new ArrayList<>();
        deliveryResponses.add(deliveryService.findByDestinationContaining(destination));
        return deliveryResponses;
    }
    @PostMapping
    public void addDelivery(@RequestBody DeliveryRequest request){
        Delivery newDelivery = new Delivery(request);
        deliveryService.save(newDelivery);
    }

    @PostMapping("/{id}/{productName}/{quantity}")
    public void addProductOrder(@PathVariable int id, @PathVariable String productName, @PathVariable int quantity){
        Product product =  new Product(productService.getProductByName(productName));

        ProductOrder productOrder = new ProductOrder(quantity, product);
        deliveryService.addProductOrder(id, productOrder);
    }
}
