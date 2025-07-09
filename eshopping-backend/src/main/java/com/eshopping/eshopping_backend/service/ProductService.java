package com.eshopping.eshopping_backend.service;

import com.eshopping.eshopping_backend.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> getProducts();
    Optional<ProductDto> getProductByID(Long prodId);
    ProductDto addProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto);
    void deleteProduct(Long productId);
}
