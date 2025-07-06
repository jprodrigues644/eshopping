package com.eshopping.eshopping_backend.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class OrderItem {

       private Product item ;
       private int quantity;
       private User user ;


}
