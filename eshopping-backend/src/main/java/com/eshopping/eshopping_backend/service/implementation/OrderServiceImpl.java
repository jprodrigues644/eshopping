package com.eshopping.eshopping_backend.service.implementation;

import com.eshopping.eshopping_backend.dto.OrderDto;
import com.eshopping.eshopping_backend.mapper.OrderMapper;
import com.eshopping.eshopping_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl {


    @Autowired
   private OrderRepository orderRepo;


    List<OrderDto> getAllOrders(){
        return orderRepo.findAll().stream()
                .map(OrderMapper::mapToOrderDto )
                .collect(Collectors.toList());
    }


}


