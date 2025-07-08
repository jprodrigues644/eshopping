package com.eshopping.eshopping_backend.dto;

import com.eshopping.eshopping_backend.enums.OrderStatus;
import com.eshopping.eshopping_backend.model.OrderItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String ref; // à mettre tout en MAJ, par exemple via Mapper
    private OrderStatus status;
    private List<OrderItemDto> items;
    private LocalDateTime createdAt;

}
