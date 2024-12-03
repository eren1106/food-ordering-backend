package com.componentbased.foodordering.service;

import com.componentbased.foodordering.model.FoodItem;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MenuService {

    public List<FoodItem> getMenu() {
        return Arrays.asList(
                new FoodItem(1, "Nasi Lemak", 16.9),
                new FoodItem(2, "Curry Mee", 12.9),
                new FoodItem(3, "Roti Canai", 5.0),
                new FoodItem(4, "Laksa", 8.0),
                new FoodItem(5, "Fried Chicken", 4.0),
                new FoodItem(6, "Pizza", 5.0)
        );
    }
}
