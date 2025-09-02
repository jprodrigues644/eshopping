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
        dto.setProductId(item.getProduct().getId()); // Use product ID
        dto.setQuantity(item.getQuantity());
        dto.setUserId(item.getUser().getId());      // Use user ID
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
        order.setCreatedAt(dto.getCreatedAt());

        List<OrderItem> items = new ArrayList<>();
        if (dto.getItems() != null) {
            for (OrderItemDto itemDto : dto.getItems()) {
                OrderItem item = mapToOrderItem(itemDto);
                item.setOrder(order);
                items.add(item);
            }
        }
        order.setItems(items);
        return order;
    }

    public static OrderItem mapToOrderItem(OrderItemDto dto) {
        OrderItem item = new OrderItem();
        Product product = new Product();
        product.setId(dto.getProductId());
        item.setProduct(product);

        User user = new User();
        user.setId(dto.getUserId());
        item.setUser(user);

        item.setQuantity(dto.getQuantity());
        return item;
    }
}
