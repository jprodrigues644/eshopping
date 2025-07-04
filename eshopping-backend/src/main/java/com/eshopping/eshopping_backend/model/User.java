package com.eshopping.eshopping_backend.model;

import com.eshopping.eshopping_backend.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

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

    private String email;

    private String phone;

    @Column
    @JsonIgnore
    private String password;

    @Column(name = "role")
    private UserRole userRole;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private List<OrderItem> orderItemList;


    public User(Object o, String name, String email, String phone, String password) {
    }

    @Column(name = "created_at")
    LocalDateTime createdAt = LocalDateTime.now();

}
