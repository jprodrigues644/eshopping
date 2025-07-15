package com.eshopping.eshopping_backend.service.implementation;

import com.eshopping.eshopping_backend.dto.ProductDto;
import com.eshopping.eshopping_backend.mapper.ProductMapper;
import com.eshopping.eshopping_backend.repository.ProductRepository;
import com.eshopping.eshopping_backend.service.ProductService;
import com.eshopping.eshopping_backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDto> getProducts() {
        return repo.findAll().stream()
                .map(productMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> getProductByID(Long prodId) {
        return repo.findById(prodId)
                .map(productMapper::mapToProductDto);
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = repo.save(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    public ProductDto updateProduct(ProductDto productDto) {
       try {
           if (repo.existsById(productDto.getId())) {
               Product product = ProductMapper.mapToProduct(productDto);
               Product updatedProduct = repo.save(product);
               return productMapper.mapToProductDto(updatedProduct);
           } else {
               throw new RuntimeException("Product not found");
           }
       }
       catch (ResponseStatusException e) {
            throw e; // Relance les erreurs HTTP
                 }
       catch (DataAccessException e) {
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur de base de données");
        }
       catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erreur lors du mapping ou de la mise à jour");
    }

    }

    public void deleteProduct(Long productId) {
        repo.deleteById(productId);
    }
}
