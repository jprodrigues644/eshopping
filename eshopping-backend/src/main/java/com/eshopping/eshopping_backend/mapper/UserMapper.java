package com.eshopping.eshopping_backend.mapper;

import com.eshopping.eshopping_backend.dto.UserCreateDto;
import com.eshopping.eshopping_backend.dto.UserDto;
import com.eshopping.eshopping_backend.dto.UserLoginResponseDto;
import com.eshopping.eshopping_backend.dto.UserUpdateDto;
import com.eshopping.eshopping_backend.enums.UserRole;
import com.eshopping.eshopping_backend.model.Address;
import com.eshopping.eshopping_backend.model.User;

public class UserMapper {

    /*ublic static User mapToUser(UserDto userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail(), userDto.getPhone(), null);
    } */

    public UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone()
        );
    }

    public static User mapToUserCreate(UserCreateDto dto) {
        return new User(
                null,
                dto.getName(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getPassword(),
                UserRole.CLIENT,
                null,
                null
        );
    }

    public static UserLoginResponseDto mapToUserLoginResponseDto(User user, String token) {
        return new UserLoginResponseDto(token,
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone());
    }

    public static User mapToUserUpdate(User existingUser, UserUpdateDto userUpdateDto) {

        existingUser.setName(userUpdateDto.getName());
        existingUser.setEmail(userUpdateDto.getEmail());
        existingUser.setPhone(userUpdateDto.getPhone());

        // Mise à jour de l'adresse si elle est fournie
        if (userUpdateDto.getAddress() != null) {
            Address address = existingUser.getAddress();
            if (address == null) {
                address = new Address();
            }
            address.setStreet(userUpdateDto.getAddress().getStreet());
            address.setStreetNumber(userUpdateDto.getAddress().getStreetNumber());
            address.setCity(userUpdateDto.getAddress().getCity());
            address.setCountry(userUpdateDto.getAddress().getCountry());
            existingUser.setAddress(address);
        }

        return existingUser;
    }

}

