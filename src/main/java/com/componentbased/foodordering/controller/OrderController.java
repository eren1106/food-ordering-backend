package com.componentbased.foodordering.controller;

import com.componentbased.foodordering.model.Order;
import com.componentbased.foodordering.model.OrderItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final List<Order> storedOrders = new ArrayList<>();

    @PostMapping("/order")
    public Order placeOrder(@RequestBody List<OrderItem> orderItems) {
        // TODO: create an order according to the orderItems and add the order to storedOrders, and then return the order
        return new Order();
    }

    @GetMapping("/api/order/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        // TODO: return the order according to the selected id, throw error if id not found
        return new Order();
    }
}
