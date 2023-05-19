package com.example.elasticsearchspring.service;

import com.example.elasticsearchspring.document.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void createProductIndexBulk() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "name1", 1.0, 1, "category", "desc", "manufacturer"));
        products.add(new Product("2", "name2", 1.0, 1, "category", "desc", "manufacturer"));
        assertEquals(productService.createProductIndexBulk(products), products);
    }

    @Test
    void createProductIndex() {
    }
}