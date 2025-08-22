package com.eshopping.eshopping_backend.controller;

import com.eshopping.eshopping_backend.dto.UserCreateDto;
import com.eshopping.eshopping_backend.dto.UserDto;
import com.eshopping.eshopping_backend.model.User;
import com.eshopping.eshopping_backend.repository.UserRepository;
import com.eshopping.eshopping_backend.service.UserService;
import io.jsonwebtoken.security.Password;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class RegistrationLoginController {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserCreateDto userCreateDto) {
        // Vérifiez si l'email existe déjà
        if (userService.getUsers().stream().anyMatch(user -> user.getEmail().equals(userCreateDto.getEmail()))) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        // Utilisez le service pour ajouter l'utilisateur
        UserDto createdUser = userService.addUser(userCreateDto); // à Verifier
        return ResponseEntity.ok(createdUser);
    }


}
