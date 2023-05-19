package com.example.elasticsearchspring.service;

import com.example.elasticsearchspring.document.Product;
import com.example.elasticsearchspring.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Iterable<Product> createProductIndexBulk(final List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product createProductIndex(final Product product) {
        return productRepository.save(product);
    }
}