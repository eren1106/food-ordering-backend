package com.componentbased.foodordering.model;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemQuantity {
    private int itemId;
    private int quantity;
}
