package com.eshopping.eshopping_backend.service;


import com.eshopping.eshopping_backend.dto.UserCreateDto;
import com.eshopping.eshopping_backend.dto.UserLoginDto;

public interface UserService {
   UserCreateDto createUserDTO(UserCreateDto userCreateDTO);
   UserLoginDto loginUserDTO (UserLoginDto userLoginDto);
}
