// OrderItem.java
package com.eshopping.eshopping_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       // Nommer le champ "product" (et non "item") pour plus de clarté
       @ManyToOne
       @JoinColumn(name = "product_id", nullable = false)
       private Product product;

       private int quantity;

       @ManyToOne
       @JoinColumn(name = "user_id", nullable = false)
       private User user;

       @ManyToOne
       @JoinColumn(name = "order_id")
       private Order order;
}