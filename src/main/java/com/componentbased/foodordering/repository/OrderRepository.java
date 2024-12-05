package com.componentbased.foodordering.repository;

import com.componentbased.foodordering.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

