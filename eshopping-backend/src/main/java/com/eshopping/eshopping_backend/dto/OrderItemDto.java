package com.eshopping.eshopping_backend.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long productId;
    private int quantity;
    private Long userId;
}
