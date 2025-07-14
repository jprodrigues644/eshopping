package com.eshopping.eshopping_backend.mapper;

import com.eshopping.eshopping_backend.dto.OrderDto;
import com.eshopping.eshopping_backend.dto.OrderItemDto;
import com.eshopping.eshopping_backend.model.Order;
import com.eshopping.eshopping_backend.model.OrderItem;
import com.eshopping.eshopping_backend.model.Product;
import com.eshopping.eshopping_backend.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    // =====================
    // Entity → DTO
    // =====================

    public static OrderDto mapToOrderDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setRef(order.getRef());
        dto.setStatus(order.getStatus());
        dto.setCreatedAt(order.getCreatedAt());

        List<OrderItemDto> itemDto = order.getItems()
                .stream()
                .map(OrderMapper::mapToOrderItemDto)
                .collect(Collectors.toList());

        dto.setItems(itemDto);

        return dto;
    }

    public static OrderItemDto mapToOrderItemDto(OrderItem item) {
        OrderItemDto dto = new OrderItemDto();
        dto.setProductId(item.getItem() != null ? item.getItem().getId() : null);
        dto.setQuantity(item.getQuantity());
        dto.setUserId(item.getUser() != null ? item.getUser().getId() : null);
        return dto;
    }

    // =====================
    // DTO → Entity
    // =====================

    public static Order mapToOrder(OrderDto dto, List<OrderItem> items) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setRef(dto.getRef() != null ? dto.getRef().toUpperCase() : null);
        order.setStatus(dto.getStatus());
        //order.setCreatedAt(dto.getCreatedAt()); // ou ne pas setter si @PrePersist s’en charge
        order.setItems(items);

        // Remplir la relation inverse
        items.forEach(i -> i.setOrder(order));

        return order;
    }

    public static OrderItem mapToOrderItem(OrderItemDto dto, Product product, User user) {
        OrderItem item = new OrderItem();
        item.setItem(product);
        item.setQuantity(dto.getQuantity());
        item.setUser(user);
        return item;
    }

    private OrderItemDto convertItemToDto(OrderItem item) {
        OrderItemDto dto = new OrderItemDto();
        dto.setProductId(item.getItem().getId());
        dto.setQuantity(item.getQuantity());
        dto.setUserId(item.getUser().getId());
        return dto;
    }
}
