package com.componentbased.foodordering.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.componentbased.foodordering.dto.CheckoutResponse;
import com.componentbased.foodordering.dto.OrderResponse;
import com.componentbased.foodordering.model.OrderItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.componentbased.foodordering.model.CheckoutDetail;
import com.componentbased.foodordering.model.ItemQuantity;
import com.componentbased.foodordering.model.Order;
import com.componentbased.foodordering.service.CheckoutService;
import com.componentbased.foodordering.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService service;
    private final CheckoutService checkoutService;

    public OrderController(OrderService service, CheckoutService checkoutService) {
        this.service = service;
        this.checkoutService = checkoutService;
    }

    @PostMapping("/order")
    public OrderResponse placeOrder(@RequestBody List<ItemQuantity> items) {
        CheckoutResponse checkoutResponse = checkoutService.calculateCheckout(items);

        Order order = new Order();

        List<OrderItem> orderItems = checkoutResponse.getOrderItems().stream()
                .map(itemResponse -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setFoodItemId(itemResponse.getItem().getId());
                    orderItem.setQuantity(itemResponse.getQuantity());
                    return orderItem;
                })
                .collect(Collectors.toList());

        order.setItems(orderItems);
        order.setSubtotal(checkoutResponse.getSubTotal());
        order.setServiceCharge(checkoutResponse.getServiceCharge());
        order.setTotal(checkoutResponse.getTotal());

        return service.placeOrder(order);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderSummaryById(@PathVariable Long id) {
        Optional<Order> orderOpt = service.getOrderById(id);

        if (orderOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Order order = orderOpt.get();
        service.getOrderSummary(order);

        return ResponseEntity.ok(order);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrder() {
        return service.getAllOrders();
    }
}