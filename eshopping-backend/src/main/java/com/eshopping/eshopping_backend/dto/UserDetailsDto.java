package com.eshopping.eshopping_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.StringDecoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {


    // Dans cette Classe on va afficcher les details d'une classe User

    private String name ;
    private String  email;
    private String phone ;
    private String street;
    private  String city;
    private String country;




}
