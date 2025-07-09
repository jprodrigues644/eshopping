package com.eshopping.eshopping_backend.mapper;

import com.eshopping.eshopping_backend.dto.ProductDto;
import com.eshopping.eshopping_backend.model.Product;

public class ProductMapper {

    public static Product mapToProduct(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getImageUrl(),
                productDto.getCreatedAt()
        );
    }

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl(),
                product.getCreatedAt()
        );
    }
}
