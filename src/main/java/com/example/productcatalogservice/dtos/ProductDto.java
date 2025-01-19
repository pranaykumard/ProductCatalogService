package com.example.productcatalogservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
    private Long id;

    private String title;

    private String description;

    private String imageUrl;

    private Double amount;

    private CategoryDto category;
}
