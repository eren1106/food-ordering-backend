package com.componentbased.foodordering.repository;


import com.componentbased.foodordering.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}

