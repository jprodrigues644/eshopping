package com.eshopping.eshopping_backend.dto;

import com.eshopping.eshopping_backend.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserCreateDto {
    //private Long id;
    private String name;
    private String email;
    private String phone;
    private String password ;
   // private  STr


}
