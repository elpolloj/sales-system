package com.example.sales_system.controller;

import com.example.sales_system.model.Product;
import com.example.sales_system.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldCreateProduct() throws Exception {
        String productJson = "{\"name\": \"Product 1\", \"description\": \"Description 1\", \"category\": \"Category 1\", \"creationDate\": \"2024-06-23T00:00:00\"}";

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Product 1"));
    }

    @Test
    void shouldFetchProducts() throws Exception {
        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("Description 1");
        product.setCategory("Category 1");
        product.setCreationDate(LocalDateTime.now());
        productRepository.save(product);

        mockMvc.perform(get("/api/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Product 1"));
    }
}
