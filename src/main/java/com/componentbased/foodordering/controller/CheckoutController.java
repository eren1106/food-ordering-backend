package com.componentbased.foodordering.controller;

import com.componentbased.foodordering.model.FoodItem;
import com.componentbased.foodordering.model.OrderItem;
import com.componentbased.foodordering.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckoutController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/checkout")
    public double checkout(@RequestBody List<OrderItem> items) {
        // TODO: return the calculated price
        return 0;
    }
}

