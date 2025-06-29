package com.eshopping.eshopping_backend.repository;


import com.eshopping.eshopping_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
