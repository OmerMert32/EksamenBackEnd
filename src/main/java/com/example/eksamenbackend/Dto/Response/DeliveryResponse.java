package com.example.eksamenbackend.Dto.Response;

import com.example.eksamenbackend.Entity.Delivery;
import com.example.eksamenbackend.Entity.ProductOrder;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryResponse {

    int id;
    LocalDate deliveryDate;

    String fromWareHouse;

    String destination;

    List<ProductOrder> productOrder;

    int totalPrice;

    int totalWeight;



    public DeliveryResponse(Delivery d){
        this.id = d.getId();
        this.deliveryDate = d.getDeliveryDate();
        this.fromWareHouse = d.getFromWareHouse();
        this.destination = d.getDestination();
        this.productOrder = d.getProductOrder();
        this.totalPrice = d.getTotalPrice();
        this.totalWeight = d.getTotalWeight();
    }
}
