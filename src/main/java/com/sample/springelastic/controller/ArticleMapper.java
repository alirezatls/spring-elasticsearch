package com.sample.springelastic.controller;

import com.sample.springelastic.domain.Article;

public class ArticleMapper {

    public static Article map(ArticleRequest request) {
        return Article.builder()
                .name(request.getName())
                .author(request.getAuthor())
                .title(request.getTitle())
                .build();
    }
}
