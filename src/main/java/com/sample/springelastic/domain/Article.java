package com.sample.springelastic.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder
@Document(indexName = "article", createIndex = true)
public class Article {
    @Id
    private String id;
    private String name;
    private String title;
    private String author;
}
