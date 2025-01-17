package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import org.springframework.beans.BeanUtils;
import com.example.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;


    @GetMapping("/products")
    public List<Product> getProducts(){
        return null;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId){
        try {
            if (productId < 1)
                throw new RuntimeException("Product not found");
            Product product = productService.getProductById(productId);
            if (product == null)
                return null;
            return new ResponseEntity<>(from(product), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setAmount(product.getAmount());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setDescription(product.getDescription());
        productDto.setTitle(product.getTitle());
        if(product.getCategory()!=null){
            Category c = new Category();
            c.setName(product.getCategory().getName());
            c.setDescription(product.getCategory().getDescription());
            c.setId(product.getCategory().getId());
            productDto.setCategory(c);
        }
        return productDto;
    }


    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto product){
        return null;
    }
}
