package com.componentbased.foodordering.controller;

import com.componentbased.foodordering.model.FoodItem;
import com.componentbased.foodordering.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public List<FoodItem> viewMenu() {
        return menuService.getMenu();
    }
}
