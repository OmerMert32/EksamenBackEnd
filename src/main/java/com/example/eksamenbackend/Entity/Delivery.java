package com.example.eksamenbackend.Entity;

import com.example.eksamenbackend.Dto.Request.DeliveryRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_delivery")
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    LocalDate deliveryDate;

    String fromWareHouse;

    String destination;

    @OneToMany
    List<ProductOrder> productOrder;

    int totalPrice;

    int totalWeight;


    public Delivery(DeliveryRequest request){
        this.deliveryDate = LocalDate.now().plusDays(1);
        this.fromWareHouse = request.getFromWareHouse();
        this.destination = request.getDestination();
    }

    public Delivery(LocalDate deliveryDate, String fromWareHouse, String destination, List<ProductOrder> productOrder) {
        this.deliveryDate = deliveryDate;
        this.fromWareHouse = fromWareHouse;
        this.destination = destination;
        this.productOrder = productOrder;
        int totalprice = 0;
        for (ProductOrder order : productOrder) {
            totalprice += order.getProduct().getPrice() * order.getQuantity();
        }
        this.totalPrice = totalprice;

        int totalWeight = 0;
        for (ProductOrder order : productOrder){
            totalWeight += order.getProduct().getWeight() * order.getQuantity();
        }
        this.totalWeight = totalWeight;
    }
    public Delivery(String fromWareHouse, String destination, List<ProductOrder> productOrder) {
        this.fromWareHouse = fromWareHouse;
        this.destination = destination;
        this.productOrder = productOrder;
        int totalprice = 0;
        for (ProductOrder order : productOrder) {
            totalprice += order.getProduct().getPrice() * order.getQuantity();
        }
        this.totalPrice = totalprice;

        int totalWeight = 0;
        for (ProductOrder order : productOrder){
            totalWeight += order.getProduct().getWeight() * order.getQuantity();
        }
        this.totalWeight = totalWeight;
    }
}
