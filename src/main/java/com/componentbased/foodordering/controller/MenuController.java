package com.componentbased.foodordering.controller;

import com.componentbased.foodordering.model.FoodItem;
import com.componentbased.foodordering.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuController {
    private final MenuService service;

    public MenuController(MenuService service) {
        this.service = service;
    }

    @GetMapping("/menu")
    public List<FoodItem> getMenu() {
        return service.getAllMenuItems();
    }
}
