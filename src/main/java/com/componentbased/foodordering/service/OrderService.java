package com.componentbased.foodordering.service;

import com.componentbased.foodordering.model.*;
import com.componentbased.foodordering.repository.FoodItemRepository;
import com.componentbased.foodordering.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final FoodItemRepository foodItemRepository;

    public OrderService(OrderRepository repository, FoodItemRepository foodItemRepository) {
        this.repository = repository;
        this.foodItemRepository = foodItemRepository;
    }

    public Order placeOrder(Order order) {
        return repository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {
        return repository.findById(id);
    }

    public List<Order> getAllOrders() {
        List<Order> orders = repository.findAll();
        orders.forEach(this::getOrderSummary);
        return orders;
    }

    public void getOrderSummary(Order order) {
        if (order == null || order.getItems() == null) {
            return;
        }

        order.getItems().forEach(orderItem -> {
            Optional<FoodItem> foodItemOpt = foodItemRepository.findById(orderItem.getFoodItemId());
            foodItemOpt.ifPresent(foodItem -> {
                double total = foodItem.getPrice() * orderItem.getQuantity();
                orderItem.setItemTotal(total);
                orderItem.setFoodItemName(foodItem.getName());
                orderItem.setFoodItemPrice(foodItem.getPrice());

            });
        });
    }
}

