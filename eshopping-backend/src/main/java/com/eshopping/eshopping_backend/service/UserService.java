package com.eshopping.eshopping_backend.service;


import com.eshopping.eshopping_backend.dto.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {
   UserCreateDto createUserDTO(UserCreateDto userCreateDTO);
   UserLoginResponseDto loginUserDTO(UserLoginDto userLoginDto);
   List<UserDto> getUsers();
   Optional<UserDto> getUserById(Long userId);
   UserDto addUser(UserCreateDto userCreateDto);
   UserDto updateUser(Long userId, UserUpdateDto userUpdateDto);
   void deleteUser(Long userId);
}
