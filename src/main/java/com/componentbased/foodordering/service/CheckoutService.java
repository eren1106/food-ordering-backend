package com.componentbased.foodordering.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.componentbased.foodordering.dto.CheckoutResponse;
import com.componentbased.foodordering.dto.FoodItemResponse;
import com.componentbased.foodordering.dto.OrderItemResponse;
import org.springframework.stereotype.Service;

import com.componentbased.foodordering.model.CheckoutDetail;
import com.componentbased.foodordering.model.FoodItem;
import com.componentbased.foodordering.model.ItemQuantity;
import com.componentbased.foodordering.model.OrderItem;
import com.componentbased.foodordering.repository.FoodItemRepository;

@Service
public class CheckoutService {
    private final FoodItemRepository foodItemRepository;
    private static final double SERVICE_CHARGE_RATE = 0.06;

    public CheckoutService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public CheckoutResponse calculateCheckout(List<ItemQuantity> items) {
        List<OrderItemResponse> orderItems = new ArrayList<>();
        double subtotal = 0.0;

        for (ItemQuantity item : items) {
            FoodItem foodItem = foodItemRepository.findById((long) item.getItemId())
                    .orElseThrow(() -> new RuntimeException("Food item not found"));

            OrderItemResponse orderItemResponse = new OrderItemResponse();
            orderItemResponse.setQuantity(item.getQuantity());

            FoodItemResponse foodItemResponse = new FoodItemResponse();
            foodItemResponse.setId(foodItem.getId());
            foodItemResponse.setName(foodItem.getName());
            foodItemResponse.setPrice(foodItem.getPrice());

            orderItemResponse.setItem(foodItemResponse);
            orderItems.add(orderItemResponse);

            subtotal += foodItem.getPrice() * item.getQuantity();
        }

        double serviceCharge = subtotal * 0.06;
        double total = subtotal + serviceCharge;

        CheckoutResponse response = new CheckoutResponse();
        response.setOrderItems(orderItems);
        response.setSubTotal(subtotal);
        response.setServiceCharge(serviceCharge);
        response.setTotal(total);

        return response;
    }
}
