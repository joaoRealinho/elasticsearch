package com.example.elasticsearchspring.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.elasticsearchspring.repository")
@ComponentScan(basePackages = {"com.example.elasticsearchspring.service"})
public class ElasticsearchClientConfig extends ElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.username}")
    private String username;
    @Value("${elasticsearch.password}")
    private String password;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(host)
                .withBasicAuth(username, password)
                .build();
    }
}