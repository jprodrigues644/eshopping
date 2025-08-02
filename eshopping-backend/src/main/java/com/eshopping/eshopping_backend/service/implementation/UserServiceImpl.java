package com.eshopping.eshopping_backend.service.implementation;

import com.eshopping.eshopping_backend.dto.UserCreateDto;
import com.eshopping.eshopping_backend.dto.UserDto;
import com.eshopping.eshopping_backend.dto.UserLoginDto;
import com.eshopping.eshopping_backend.dto.UserLoginResponseDto;
import com.eshopping.eshopping_backend.mapper.UserMapper;
import com.eshopping.eshopping_backend.repository.UserRepository;
import com.eshopping.eshopping_backend.security.JwtService;
import com.eshopping.eshopping_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class userServiceImpl implements UserService {


    @Autowired
    private final UserRepository userRepository;
    @Autowired

    private final UserMapper userMapper;
    @Autowired

    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtService jwtService;




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
        if(!userRepository.existsById(userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found : " + UserId);
        }

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
