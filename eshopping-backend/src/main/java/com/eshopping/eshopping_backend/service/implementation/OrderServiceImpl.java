package com.eshopping.eshopping_backend.service.implementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.eshopping.eshopping_backend.dto.OrderDto;
import com.eshopping.eshopping_backend.mapper.OrderMapper;
import com.eshopping.eshopping_backend.model.Order;
import com.eshopping.eshopping_backend.model.Product;
import com.eshopping.eshopping_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl {


    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private OrderMapper orderMapper;


    List<OrderDto> getAllOrders() {
        return orderRepo.findAll().stream()
                .map(OrderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }


    List<OrderDto> getOrdersByUserId(Long userId) {
        
        return orderRepo.findByUserId(userId)
                .stream()
                .map(OrderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }
    public  OrderDto addOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        Order savedOrder = orderRepo.save(order);
        return OrderMapper.mapToOrderDto(savedOrder);
    }
    public OrderDto updateOrder(OrderDto orderDto) {
        try {
            Order order = OrderMapper.mapToOrder(orderDto);
            Order savedOrder = orderRepo.save(order);
            return OrderMapper.mapToOrderDto(savedOrder);

        } catch (DataAccessException e) {
            // Si l'entité n'existe pas, JPA lèvera une exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commande non trouvée");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la mise à jour");
        }
    }


    void deleteOrder(Long id) {
        if (!orderRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commande non trouvée avec l'ID : " + id);
        }
        orderRepo.deleteById(id);
    }

}
