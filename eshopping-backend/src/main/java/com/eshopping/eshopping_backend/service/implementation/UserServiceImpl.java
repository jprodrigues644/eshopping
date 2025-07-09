package com.eshopping.eshopping_backend.service.implementation;

import com.eshopping.eshopping_backend.dto.UserCreateDto;
import com.eshopping.eshopping_backend.dto.UserDto;
import com.eshopping.eshopping_backend.dto.UserLoginDto;
import com.eshopping.eshopping_backend.mapper.UserMapper;
import com.eshopping.eshopping_backend.model.User;
import com.eshopping.eshopping_backend.repository.UserRepository;
import com.eshopping.eshopping_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Autowired
    UserMapper userMapper;

    public List<UserDto> getUsers(){
        return repo.findAll().stream()
                .map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }
    public Optional<UserDto> getUserId (Long userId){
        return repo.findById(userId).map(userMapper::mapToUserDto);

    }

    @Override
    public UserCreateDto createUserDTO(UserCreateDto userCreateDTO) {
        return null;
    }

    public UserLoginDto loginUserDTO (UserLoginDto userLoginDto) {
        return null;
    }
}
