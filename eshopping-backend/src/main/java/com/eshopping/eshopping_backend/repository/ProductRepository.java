package com.eshopping.eshopping_backend.repository;

import com.eshopping.eshopping_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    
    }

