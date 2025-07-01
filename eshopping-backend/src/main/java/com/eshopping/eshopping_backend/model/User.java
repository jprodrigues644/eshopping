package com.eshopping.eshopping_backend.model;

import com.eshopping.eshopping_backend.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @JsonIgnore
    @Column
    private String password;
    @Column
    private UserRole userRole;


    public User(Object o, String name, String email, String phone, String password) {
    }
}
