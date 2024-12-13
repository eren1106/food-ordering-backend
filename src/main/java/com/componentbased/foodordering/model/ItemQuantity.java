package com.componentbased.foodordering.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemQuantity {
    private int itemId;
    private int quantity;

    public int getItemId() {
        return itemId;
    }

    public void setItemId (int itemId) { this.itemId = itemId; }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity (int quantity) { this.quantity = quantity; }

}
