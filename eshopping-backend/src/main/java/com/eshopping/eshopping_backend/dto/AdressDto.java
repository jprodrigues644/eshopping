package com.eshopping.eshopping_backend.dto;

import com.eshopping.eshopping_backend.model.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class AdressDto {
    private Long id ;
    private String street;
    private  String city;
    private String country;
    private User user;
    private  LocalDateTime createdAt ;
}
