package com.eshopping.eshopping_backend.dto;

import com.eshopping.eshopping_backend.model.Product;
import com.eshopping.eshopping_backend.model.User;
import lombok.Data;

@Data
public class OrderItemDto {
    private Product product;
    private int quantity;
    private User user;

}
