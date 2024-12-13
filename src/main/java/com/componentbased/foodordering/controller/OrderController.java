package com.componentbased.foodordering.controller;

import com.componentbased.foodordering.model.CheckoutDetail;
import com.componentbased.foodordering.model.ItemQuantity;
import com.componentbased.foodordering.model.Order;
import com.componentbased.foodordering.service.CheckoutService;
import com.componentbased.foodordering.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Order placeOrder(@RequestBody List<ItemQuantity> items) {
        CheckoutDetail checkoutDetail = checkoutService.calculateCheckout(items);

        Order order = new Order();
        order.setItems(checkoutDetail.getItems());
        order.setSubtotal(checkoutDetail.getSubtotal());
        order.setServiceCharge(checkoutDetail.getServiceCharge());
        order.setTotal(checkoutDetail.getTotal());

        return service.placeOrder(order);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return service.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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