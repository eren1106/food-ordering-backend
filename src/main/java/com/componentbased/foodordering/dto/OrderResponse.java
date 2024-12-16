package com.componentbased.foodordering.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderResponse {
    private Long id;
    private List<OrderItemResponse> orderItems;
    private double subTotal;
    private double serviceCharge;
    private double total;
}


