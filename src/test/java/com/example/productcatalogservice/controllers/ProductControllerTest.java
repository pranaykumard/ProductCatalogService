package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockitoBean
    private IProductService productService;

    @Test
    public void TestGetProductById_WithValidProductId_RunSuccessfully(){
        //Arrange
        Long productId = 4L;
        Product product = new Product();
        product.setId(productId);
        product.setTitle("Test 4 ");
        when(productService.getProductById(productId)).thenReturn(product);
        //Act
        ResponseEntity<ProductDto> response = productController.getProductById(productId);

        //Assert
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(productId,response.getBody().getId());
        assertEquals("Harsha Test 4 ",response.getBody().getTitle());
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
    @Test
    public void TestGetProductById_WithInvalidId_ResultsInRunTimeException(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> productController.getProductById(-1L));
        assertEquals("Product not found", exception.getMessage());

    }

    @Test
    public void TestGetProductById_WhenProductServiceThrowsException(){
        when(productService.getProductById(any(Long.class))).thenThrow(new RuntimeException("something is wrong!"));
        assertThrows(RuntimeException.class, () -> productController.getProductById(2000L));

    }
}