package com.example.productcatalogservice.repos;

import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void testFetchTypes(){
        Category category = categoryRepo.findById(3L).get();

        for(Product product:category.getProducts()){
            System.out.println(product.getDescription());
        }
    }

    @Test
    @Transactional
    public void testFetchModesAndTypes(){
        Category category = categoryRepo.findById(1L).get();
        for(Product product:category.getProducts()){
            System.out.println(product.getDescription());
        }

    }

    @Test
    @Transactional
    public void runSubqueries(){
        List<Category> categories = categoryRepo.findAll();
        for(Category category:categories){
            for(Product product:category.getProducts()){
                System.out.println(product.getDescription());
            }
        }
    }

}