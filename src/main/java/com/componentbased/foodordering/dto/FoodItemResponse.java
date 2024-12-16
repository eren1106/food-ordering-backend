package com.componentbased.foodordering.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FoodItemResponse {
    private Long id;
    private String name;
    private double price;
}