package com.componentbased.foodordering.controller;

import com.componentbased.foodordering.model.Order;
import com.componentbased.foodordering.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/order")
    public Order placeOrder(@RequestBody Order order) {
        // TODO: add order to db and return it
        return null;
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable Long id) {
        // TODO: get order by id and return it
        return null;
    }
}
