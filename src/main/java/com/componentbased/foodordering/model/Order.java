package com.componentbased.foodordering.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private double subtotal;
    private double serviceCharge;
    private double total;
    // Constructors, getters, and setters
}

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Order {
//    private int id;
//    private List<OrderItem> items;
//    private double subtotal;
//    private double serviceCharge;
//    private double total;
//}
