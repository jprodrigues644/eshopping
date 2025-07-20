package com.eshopping.eshopping_backend.repository;

import com.eshopping.eshopping_backend.dto.OrderItemDto;
import com.eshopping.eshopping_backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository  extends JpaRepository <OrderItem, Long> {
    List<OrderItem> findByUserId(Long userId);
}
