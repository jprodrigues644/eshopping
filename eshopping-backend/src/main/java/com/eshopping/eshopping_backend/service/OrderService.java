package com.eshopping.eshopping_backend.service;

import com.eshopping.eshopping_backend.dto.OrderDto;
import com.eshopping.eshopping_backend.model.Order;

import java.util.List;

public interface OrderService {


    List <OrderDto>getOrders() ;
    List <OrderDto>getOrdersByUser( );
    List  <Order>getOrderItems();

}
