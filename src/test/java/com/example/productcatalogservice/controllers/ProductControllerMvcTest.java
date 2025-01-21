package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private IProductService productService;

    @Test
    public void TestGetAllProducts_RunSuccessfully() throws Exception {
        Product product = new Product();
        product.setTitle("Test Product");
        product.setId(1L);

        Product product2 = new Product();
        product2.setTitle("Test Product2");
        product2.setId(2L);

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);

        when(productService.getAllProducts()).thenReturn(productList);

        mockMvc.perform(get("/products")).
                andExpect(status().isOk()).andExpect(content().string(objectMapper.writeValueAsString(productList)));

    }
}
