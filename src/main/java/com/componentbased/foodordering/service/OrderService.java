package com.componentbased.foodordering.service;

import com.componentbased.foodordering.model.Order;
import com.componentbased.foodordering.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order placeOrder(Order order) {
        return repository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {
        return repository.findById(id);
    }
}

