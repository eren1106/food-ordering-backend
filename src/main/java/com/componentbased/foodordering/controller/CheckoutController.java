package com.componentbased.foodordering.controller;

import com.componentbased.foodordering.model.CheckoutDetail;
import com.componentbased.foodordering.model.ItemQuantity;
import com.componentbased.foodordering.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckoutController {
    private final MenuService menuService;

    public CheckoutController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/checkout")
    public CheckoutDetail checkout(@RequestBody List<ItemQuantity> items) {
        // TODO: return Checkout object based on the items
        return null;
    }
}


