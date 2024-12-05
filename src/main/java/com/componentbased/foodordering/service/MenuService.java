package com.componentbased.foodordering.service;

import com.componentbased.foodordering.model.FoodItem;
import com.componentbased.foodordering.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final FoodItemRepository repository;

    public MenuService(FoodItemRepository repository) {
        this.repository = repository;
    }

    public List<FoodItem> getAllMenuItems() {
        return repository.findAll();
    }
}

