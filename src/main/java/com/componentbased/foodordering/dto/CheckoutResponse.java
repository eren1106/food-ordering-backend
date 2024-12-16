package com.componentbased.foodordering.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CheckoutResponse {
    private List<OrderItemResponse> orderItems;
    private double subTotal;
    private double serviceCharge;
    private double total;

}
