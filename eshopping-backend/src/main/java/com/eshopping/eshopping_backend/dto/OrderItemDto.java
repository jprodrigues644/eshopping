package com.eshopping.eshopping_backend.dto;

import com.eshopping.eshopping_backend.model.Product;
import com.eshopping.eshopping_backend.model.User;
import lombok.Data;

@Data

public class OrderItemDto {
    private Long productId; // Use ID instead of Product object
    private int quantity;
    private Long userId;    // Use ID instead of User object
}
