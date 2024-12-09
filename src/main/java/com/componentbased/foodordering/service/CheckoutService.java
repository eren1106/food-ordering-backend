package com.componentbased.foodordering.service;

import com.componentbased.foodordering.model.CheckoutDetail;
import com.componentbased.foodordering.model.FoodItem;
import com.componentbased.foodordering.model.ItemQuantity;
import com.componentbased.foodordering.model.OrderItem;
import com.componentbased.foodordering.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckoutService {
    private final FoodItemRepository foodItemRepository;
    private static final double SERVICE_CHARGE_RATE = 0.06;

    public CheckoutService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public CheckoutDetail calculateCheckout(List<ItemQuantity> items) {
        List<OrderItem> orderItems = new ArrayList<>();
        double subtotal = 0.0;

        for (ItemQuantity item : items) {
            System.out.println("Looking for food item with id: " + item.getItemId());
            FoodItem foodItem = foodItemRepository.findById((long) item.getItemId())
                    .orElseThrow(() -> new RuntimeException("Food item not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setFoodItemId(foodItem.getId());
            orderItem.setQuantity(item.getQuantity());
            orderItems.add(orderItem);

            subtotal += foodItem.getPrice() * item.getQuantity();
        }

        double serviceCharge = subtotal * SERVICE_CHARGE_RATE;
        double total = subtotal + serviceCharge;

        return new CheckoutDetail(orderItems, subtotal, serviceCharge, total);
    }
}