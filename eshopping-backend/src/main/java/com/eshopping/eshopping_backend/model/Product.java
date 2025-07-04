package com.eshopping.eshopping_backend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "products")
public class Product {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id ;
     @Column
     private String name ;
     @Column
     private double price ;
     private String description;
     private  String imageUrl;

     @Column(name = "created_at")
     LocalDateTime createdAt = LocalDateTime.now();
}
