package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts(){
        return null;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long productId){
        Product product = new Product();
        product.setId(productId);
        product.setTitle("Samsung galaxy");
        product.setDescription("Samsung galaxy is good! ");
        product.setAmount(20000.0);
        return product;

    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return null;
    }
}
