package com.eshopping.eshopping_backend.dto;

import com.eshopping.eshopping_backend.model.User;

import java.time.LocalDateTime;

public class AddressDto {
    private Long id ;
    private String street;
    private  String city;
    private String country;
    private User user;
    private  int streeNumber;
    private  LocalDateTime createdAt ;
}
