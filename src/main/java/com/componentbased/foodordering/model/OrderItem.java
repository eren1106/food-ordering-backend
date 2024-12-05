package com.componentbased.foodordering.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long foodItemId;
    private Integer quantity;

    // Constructors, getters, and setters
}

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private Long foodItemId;
//    private Integer quantity;
//
//    // Constructors, getters, and setters
//}


