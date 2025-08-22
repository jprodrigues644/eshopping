package com.eshopping.eshopping_backend.dto;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String name;        // Nom de l'utilisateur
    private String email;       // Email de l'utilisateur
    private String phone;       // Numéro de téléphone de l'utilisateur
    private AddressDto address; // Adresse de l'utilisateur
    private String oldPassword; // Ancien mot de passe (nécessaire pour la mise à jour du mot de passe)
    private String newPassword; // Nouveau mot de passe (optionnel)
}


