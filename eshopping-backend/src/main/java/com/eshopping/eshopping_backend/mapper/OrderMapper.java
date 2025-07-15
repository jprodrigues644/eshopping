package com.eshopping.eshopping_backend.mapper;

import com.eshopping.eshopping_backend.dto.OrderDto;
import com.eshopping.eshopping_backend.dto.OrderItemDto;
import com.eshopping.eshopping_backend.model.Order;
import com.eshopping.eshopping_backend.model.OrderItem;
import com.eshopping.eshopping_backend.model.Product;
import com.eshopping.eshopping_backend.model.User;

import java.util.ArrayList;
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
        dto.setProduct(item.getProduct());
        dto.setQuantity(item.getQuantity());
        dto.setUser(dto.getUser());
        return dto;
    }

    // =====================
    // DTO → Entity
    // =====================

    public static Order mapToOrder(OrderDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setRef(dto.getRef() != null ? dto.getRef().toUpperCase() : null);
        order.setStatus(dto.getStatus());
        order.setUser(dto.getUser());
        order.setCreatedAt(dto.getCreatedAt()); // facultatif selon @PrePersist

        // Mapper les OrderItemDto -> OrderItem
        List<OrderItem> items = new ArrayList<>();
        if (dto.getItems() != null) {
            for (OrderItemDto itemDto : dto.getItems()) {
                OrderItem item = mapToOrderItem(itemDto , itemDto.getProductId(),itemDto.getUserId() ); // tu dois avoir ou créer ce mapper
                item.setOrder(order); // relation inverse
                items.add(item);
            }
        }

        order.setItems(items);
        return order;
    }


    public static OrderItem mapToOrderItem(OrderItemDto dto) {
        OrderItem item = new OrderItem();
        item.setProduct(dto.getProduct());
        item.setQuantity(dto.getQuantity());
        item.setUser(dto.getUser());
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
