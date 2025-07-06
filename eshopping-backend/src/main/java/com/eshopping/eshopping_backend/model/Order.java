package com.eshopping.eshopping_backend.model;

import com.eshopping.eshopping_backend.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String ref ;
    private OrderStatus status ;
    private List <OrderItem> items;


    @Column(name = "created_at")
    LocalDateTime createdAt = LocalDateTime.now();
}
