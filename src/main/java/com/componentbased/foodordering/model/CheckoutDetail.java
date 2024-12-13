package com.componentbased.foodordering.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutDetail {
    private List<OrderItem> items;
    private double subtotal;
    private double serviceCharge;
    private double total;

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) { this.items = items; }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double subtotal) { this.serviceCharge = serviceCharge; }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) { this.total = total; }
}