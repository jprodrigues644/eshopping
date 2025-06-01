package com.eshopping.eshopping_backend.mapper;

import com.eshopping.eshopping_backend.dto.UserCreateDto;
import com.eshopping.eshopping_backend.dto.UserDto;
import com.eshopping.eshopping_backend.dto.UserLoginResponseDto;
import com.eshopping.eshopping_backend.model.User;

public class UserMapper {

    /*ublic static User mapToUser(UserDto userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail(), userDto.getPhone(), null);
    } */

    public static UserDto mapToUserDto(User user){
        return new UserDto(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone());
    }

    public static User mapToUser(UserCreateDto dto) {
        return new User(
                null,
                dto.getName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getPassword()
        );
    }

    public static UserLoginResponseDto mapToUserLoginResponseDto(User user, String token) {
        return new UserLoginResponseDto(token,
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone());
    }

}

