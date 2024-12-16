package com.componentbased.foodordering.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.componentbased.foodordering.model.CheckoutDetail;
import com.componentbased.foodordering.model.ItemQuantity;
import com.componentbased.foodordering.service.CheckoutService;

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


