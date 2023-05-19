package com.example.elasticsearchspring.controller;

import com.example.elasticsearchspring.document.Product;
import com.example.elasticsearchspring.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public void createProductIndex(@RequestBody Product product) {
        productService.createProductIndex(product);
    }
}
