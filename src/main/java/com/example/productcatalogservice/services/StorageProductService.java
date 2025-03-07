package com.example.productcatalogservice.services;

import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;


    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct= productRepo.findById(id);
        return optionalProduct.get();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
}
