package com.eshopping.eshopping_backend.repository;

import com.eshopping.eshopping_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    default List<Product> findAll() {
        return null;
    }
}
