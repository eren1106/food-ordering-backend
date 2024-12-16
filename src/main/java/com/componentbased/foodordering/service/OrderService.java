package com.componentbased.foodordering.service;

import com.componentbased.foodordering.dto.OrderResponse;
import com.componentbased.foodordering.model.*;
import com.componentbased.foodordering.dto.OrderItemResponse;
import com.componentbased.foodordering.dto.FoodItemResponse;
import com.componentbased.foodordering.repository.FoodItemRepository;
import com.componentbased.foodordering.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final FoodItemRepository foodItemRepository;

    public OrderService(OrderRepository repository, FoodItemRepository foodItemRepository) {
        this.repository = repository;
        this.foodItemRepository = foodItemRepository;
    }

    public OrderResponse placeOrder(Order order) {
        Order savedOrder = repository.save(order);
        return convertToOrderResponse(savedOrder);
    }

    private OrderResponse convertToOrderResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setSubTotal(order.getSubtotal());
        response.setServiceCharge(order.getServiceCharge());
        response.setTotal(order.getTotal());

        List<OrderItemResponse> orderItems = order.getItems().stream()
                .map(this::convertToOrderItemResponse)
                .collect(Collectors.toList());

        response.setOrderItems(orderItems);

        return response;
    }

    private OrderItemResponse convertToOrderItemResponse(OrderItem orderItem) {
        OrderItemResponse response = new OrderItemResponse();
        response.setQuantity(orderItem.getQuantity());

        FoodItem foodItem = foodItemRepository.findById(orderItem.getFoodItemId())
                .orElseThrow(() -> new RuntimeException("Food item not found"));

        FoodItemResponse itemResponse = new FoodItemResponse();
        itemResponse.setId(foodItem.getId());
        itemResponse.setName(foodItem.getName());
        itemResponse.setPrice(foodItem.getPrice());

        response.setItem(itemResponse);

        return response;
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

