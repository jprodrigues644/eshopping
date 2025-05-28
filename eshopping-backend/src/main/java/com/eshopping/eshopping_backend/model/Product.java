package com.eshopping.eshopping_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

     @Id
     private long id ;
     private String name ;
     private float price ;

}
