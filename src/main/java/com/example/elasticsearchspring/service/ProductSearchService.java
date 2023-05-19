package com.example.elasticsearchspring.service;

import com.example.elasticsearchspring.document.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductSearchService {

    private static final String PRODUCT_INDEX = "productindex";

    private ElasticsearchOperations elasticsearchOperations;

    public List<IndexedObjectInformation> createProductIndexBulk
            (final List<Product> products) {

        List<IndexQuery> queries = products.stream()
                .map(product ->
                        new IndexQueryBuilder()
                                .withId(product.getId())
                                .withObject(product).build())
                .collect(Collectors.toList());

        return elasticsearchOperations
                .bulkIndex(queries, IndexCoordinates.of(PRODUCT_INDEX));
    }
}