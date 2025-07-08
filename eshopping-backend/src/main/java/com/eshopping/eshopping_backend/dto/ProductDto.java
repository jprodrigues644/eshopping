package com.eshopping.eshopping_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id ;
    private String name ;
    private String description;
    private double price ;
    private  String imageUrl;
    private LocalDateTime createdAt;
}
