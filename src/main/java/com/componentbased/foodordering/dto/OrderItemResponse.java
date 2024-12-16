package com.componentbased.foodordering.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemResponse {
    private FoodItemResponse item;
    private int quantity;
}