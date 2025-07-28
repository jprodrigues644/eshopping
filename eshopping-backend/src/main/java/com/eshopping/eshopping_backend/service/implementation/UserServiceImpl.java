package com.eshopping.eshopping_backend.service.implementation;

import com.eshopping.eshopping_backend.dto.UserCreateDto;
import com.eshopping.eshopping_backend.dto.UserDto;
import com.eshopping.eshopping_backend.dto.UserLoginDto;
import com.eshopping.eshopping_backend.dto.UserLoginResponseDto;
import com.eshopping.eshopping_backend.mapper.UserMapper;
import com.eshopping.eshopping_backend.model.User;
import com.eshopping.eshopping_backend.repository.UserRepository;
import com.eshopping.eshopping_backend.security.JwtService;
import com.eshopping.eshopping_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {



    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }


    public List<UserDto> getUsers(){
        return userRepository.findAll().stream()
                .map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }
    public Optional<UserDto> getUserById (Long userId){
        return userRepository.findById(userId).map(userMapper::mapToUserDto);

    }

    @Override
    public UserDto addUser(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public Optional<UserDto> updateUser(Long userId, UserCreateDto userCreateDto) {
        return Optional.empty();
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public UserCreateDto createUserDTO(UserCreateDto userCreateDTO) {
        return null;
    }

    @Override
    public UserLoginResponseDto loginUserDTO(UserLoginDto userLoginDto) {
        return null;
    }


}
