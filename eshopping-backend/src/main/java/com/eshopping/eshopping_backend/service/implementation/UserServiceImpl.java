package com.eshopping.eshopping_backend.service.implementation;

import com.eshopping.eshopping_backend.dto.*;
import com.eshopping.eshopping_backend.mapper.AddressMapper;
import com.eshopping.eshopping_backend.mapper.UserMapper;
import com.eshopping.eshopping_backend.model.Address;
import com.eshopping.eshopping_backend.model.User;
import com.eshopping.eshopping_backend.repository.AddressRepository;
import com.eshopping.eshopping_backend.repository.UserRepository;
import com.eshopping.eshopping_backend.security.JwtService;
import com.eshopping.eshopping_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    @Autowired
    private final UserRepository userRepo;
    @Autowired
    private final AddressRepository addressRepo;
    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final AddressMapper addressMapper;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtService jwtService;





    public List<UserDto> getUsers(){
        return userRepo.findAll().stream()
                .map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }
    public Optional<UserDto> getUserById (Long userId){
        return userRepo.findById(userId).map(userMapper::mapToUserDto);

    }

    @Override
    public UserDto addUser(UserCreateDto userCreateDto) {
        User user = UserMapper.mapToUserCreate(userCreateDto);
        userRepo.save(user);
        return  userMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUser(Long userId, UserUpdateDto userUpdateDto) {
        // 1. Récupérer l'utilisateur existant
        User existingUser = userRepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));

        // 2. Mettre à jour les informations de base
        existingUser.setName(userUpdateDto.getName());
        existingUser.setEmail(userUpdateDto.getEmail());
        existingUser.setPhone(userUpdateDto.getPhone());

        // 3. Mettre à jour l'adresse si fournie
        if (userUpdateDto.getAddress() != null) {
            Address address;
            if (existingUser.getAddress() != null) {
                address = existingUser.getAddress();
            } else {
                address = new Address();
            }
            address.setStreet(userUpdateDto.getAddress().getStreet());
            address.setStreetNumber(userUpdateDto.getAddress().getStreetNumber());
            address.setCity(userUpdateDto.getAddress().getCity());
            address.setCountry(userUpdateDto.getAddress().getCountry());
            existingUser.setAddress(address);
        }

        // 4. Mise à jour du mot de passe si nécessaire
        if (userUpdateDto.getOldPassword() != null && userUpdateDto.getNewPassword() != null) {
            // Vérifier que l'ancien mot de passe est correct
            if (!passwordEncoder.matches(userUpdateDto.getOldPassword(), existingUser.getPassword())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ancien mot de passe incorrect");
            }

            // Encoder et mettre à jour le nouveau mot de passe
            String encodedNewPassword = passwordEncoder.encode(userUpdateDto.getNewPassword());
            existingUser.setPassword(encodedNewPassword);
        }

        // 5. Sauvegarder et retourner le DTO
        User savedUser = userRepo.save(existingUser);
        return userMapper.mapToUserDto(savedUser);
    }


    @Override
    public void deleteUser(Long userId) {
        if(!userRepo.existsById(userId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found : " + userId);
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
