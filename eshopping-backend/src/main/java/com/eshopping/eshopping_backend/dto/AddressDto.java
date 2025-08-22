package com.eshopping.eshopping_backend.dto;

import com.eshopping.eshopping_backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddressDto {
    private Long id ;
    private String street;
    private  String city;
    private String country;
    private User user;
    private  int streetNumber;

}
