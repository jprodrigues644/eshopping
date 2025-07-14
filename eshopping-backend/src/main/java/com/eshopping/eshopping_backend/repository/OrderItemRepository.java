package com.eshopping.eshopping_backend.repository;

import com.eshopping.eshopping_backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository  extends JpaRepository <OrderItem, Long> {
}
