package com.example.productcatalogservice.services;

import com.example.productcatalogservice.models.Product;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface IProductService {

    public List<Product> getAllProducts();

    public Product getProductById(Long id);

    Product replaceProduct(Long id,Product product);

    public Product createProduct(Product product);
}
