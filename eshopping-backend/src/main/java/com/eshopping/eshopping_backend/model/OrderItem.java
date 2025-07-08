// OrderItem.java
package com.eshopping.eshopping_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       @ManyToOne
       @JoinColumn(name = "product_id")
       private Product item;

       private int quantity;

       @ManyToOne
       @JoinColumn(name = "user_id")
       private User user;

       @ManyToOne
       @JoinColumn(name = "order_id")
       private Order order;
}
