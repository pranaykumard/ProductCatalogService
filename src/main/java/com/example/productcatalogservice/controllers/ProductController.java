package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.dtos.CategoryDto;
import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @PutMapping("/products/{id}")
    public ProductDto replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        Product product = productService.replaceProduct(id,from(productDto));
        return from(product);
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductDto> productDtos = new ArrayList<>();
        if(products!=null && !products.isEmpty()){
            for(Product product:products){
                ProductDto productDto = from(product);
                productDtos.add(productDto);
            }
            return productDtos;
        }
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
            //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            throw e;
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
            CategoryDto c = new CategoryDto();
            c.setName(product.getCategory().getName());
            c.setDescription(product.getCategory().getDescription());
            c.setId(product.getCategory().getId());
            productDto.setCategory(c);
        }
        return productDto;
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setAmount(productDto.getAmount());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        product.setTitle(productDto.getTitle());
        if(productDto.getCategory()!=null){
            Category c = new Category();
            c.setName(productDto.getCategory().getName());
            c.setDescription(productDto.getCategory().getDescription());
            c.setId(productDto.getCategory().getId());
            product.setCategory(c);
        }
        return product;
    }


    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        Product product = productService.createProduct(from(productDto));
        return from(product);
    }


}
