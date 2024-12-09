package com.componentbased.foodordering.controller;

import com.componentbased.foodordering.model.CheckoutDetail;
import com.componentbased.foodordering.model.ItemQuantity;
import com.componentbased.foodordering.service.CheckoutService;
import com.componentbased.foodordering.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckoutController {
    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/checkout")
    public CheckoutDetail checkout(@RequestBody List<ItemQuantity> items) {
        return checkoutService.calculateCheckout(items);
    }
}


