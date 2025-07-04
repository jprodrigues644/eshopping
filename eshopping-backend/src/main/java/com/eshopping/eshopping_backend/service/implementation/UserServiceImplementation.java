package com.eshopping.eshopping_backend.service.implementation;

import com.eshopping.eshopping_backend.dto.UserCreateDto;
import com.eshopping.eshopping_backend.dto.UserLoginDto;
import com.eshopping.eshopping_backend.model.User;
import com.eshopping.eshopping_backend.repository.UserRepository;
import com.eshopping.eshopping_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImplementation  implements UserService {

    @Autowired
    UserRepository repo;

    public List<User> getUsers(){
        return repo.findAll();
    }
    public User getUserId (Long userId){
        return repo.findById(userId).orElse(new User());
    }





    @Override
    public UserCreateDto createUserDTO(UserCreateDto userCreateDTO) {
        return null;
    }

    public UserLoginDto loginUserDTO (UserLoginDto userLoginDto) {
        return null;
    }
}
