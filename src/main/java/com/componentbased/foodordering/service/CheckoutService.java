package com.componentbased.foodordering.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

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

    public CheckoutDetail calculateCheckout(List<ItemQuantity> items) {
        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal subtotal = BigDecimal.ZERO;

        for (ItemQuantity item : items) {
            System.out.println("Looking for food item with id: " + item.getItemId());
            FoodItem foodItem = foodItemRepository.findById((long) item.getItemId())
                    .orElseThrow(() -> new RuntimeException("Food item not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setFoodItemId(foodItem.getId());
            orderItem.setQuantity(item.getQuantity());
            orderItems.add(orderItem);

            BigDecimal itemTotal = BigDecimal.valueOf(foodItem.getPrice())
                    .multiply(BigDecimal.valueOf(item.getQuantity()));
            subtotal = subtotal.add(itemTotal);
        }

        BigDecimal serviceCharge = subtotal.multiply(BigDecimal.valueOf(SERVICE_CHARGE_RATE));
        BigDecimal total = subtotal.add(serviceCharge);

        // Round to 2 decimal places
        subtotal = subtotal.setScale(2, RoundingMode.HALF_UP);
        serviceCharge = serviceCharge.setScale(2, RoundingMode.HALF_UP);
        total = total.setScale(2, RoundingMode.HALF_UP);

        return new CheckoutDetail(orderItems, subtotal.doubleValue(), serviceCharge.doubleValue(), total.doubleValue());
    }
}
