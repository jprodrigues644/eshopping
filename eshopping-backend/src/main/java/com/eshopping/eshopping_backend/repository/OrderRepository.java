package com.eshopping.eshopping_backend.repository;

import com.eshopping.eshopping_backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long > {
}
