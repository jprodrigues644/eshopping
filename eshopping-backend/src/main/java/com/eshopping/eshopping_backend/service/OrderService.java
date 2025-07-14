package com.eshopping.eshopping_backend.service;

import com.eshopping.eshopping_backend.dto.OrderDto;
import com.eshopping.eshopping_backend.model.Order;

import java.util.List;

public interface OrderService {

    // Admin
    List <OrderDto>getAllOrders() ;
    // Admin and User

    List <OrderDto>getOrdersByUser( );

    // Admin and User

    List  <Order>getOrderItems();

}
