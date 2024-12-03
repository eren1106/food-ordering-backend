package com.componentbased.foodordering.controller;

import com.componentbased.foodordering.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final List<Order> orders = new ArrayList<>();

    @PostMapping("/order")
    public Order placeOrder(@RequestBody Order order) {
        orders.add(order);
        return order;
    }

    @GetMapping("/api/order/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        // TODO: return the order according to the selected id, throw error if id not found
        return new Order();
    }
}
