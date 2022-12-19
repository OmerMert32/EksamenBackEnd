package com.example.eksamenbackend.Dto.Request;

import com.example.eksamenbackend.Entity.ProductOrder;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryRequest {

    LocalDateTime deliveryDate;

    String fromWareHouse;

    String destination;

    List<ProductOrder> productOrder;
}
