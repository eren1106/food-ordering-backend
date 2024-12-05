package com.componentbased.foodordering.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutDetail {
    private List<OrderItem> items;
    private double subtotal;
    private double serviceCharge;
    private double total;
}