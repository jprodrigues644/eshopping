package com.eshopping.eshopping_backend.service.implementation;
import com.eshopping.eshopping_backend.dto.OrderItemDto;
import com.eshopping.eshopping_backend.model.OrderItem;
import com.eshopping.eshopping_backend.repository.OrderItemRepository;
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
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl {


    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private OrderItemRepository orderItemRepo;
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


    // OrderItems , articles de Commande , pour chaque Utilisateur


    public List<OrderItemDto> getOrderItemsByUser(Long userId) {
        return orderItemRepo.findByUserId(userId)
                .stream()
                .map(OrderMapper::mapToOrderItemDto)
                .collect(Collectors.toList());
        // Exception management to add
    }

    public  OrderItemDto addOrderItem(OrderItemDto orderDtoItem) {
        OrderItem order = OrderMapper.mapToOrderItem(orderDtoItem);
        OrderItem savedOrder = orderItemRepo.save(order);
        return OrderMapper.mapToOrderItemDto(savedOrder);
    }

    public OrderItemDto updateOrderItem(OrderItemDto orderItemDto) {
        try {
            OrderItem order = OrderMapper.mapToOrderItem(orderItemDto);
            OrderItem savedOrder = orderItemRepo.save(order);
            return OrderMapper.mapToOrderItemDto(savedOrder);

        } catch (DataAccessException e) {
            // If the entity doesnt exist Jpa throws a exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors de la mise à jour");
        }
    }

    void deleteOrderItem(Long id) {
        if (!orderItemRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article Not Found : " + id);
        }
        orderItemRepo.deleteById(id);
    }


}
