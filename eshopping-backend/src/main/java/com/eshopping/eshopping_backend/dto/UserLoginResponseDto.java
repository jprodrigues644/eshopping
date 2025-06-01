package com.eshopping.eshopping_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponseDto {
    private String token;
    private Long id;
    private String name;
    private String email;
    private String phone;
}