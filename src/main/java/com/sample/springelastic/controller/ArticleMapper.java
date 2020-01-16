package com.sample.springelastic.controller;

import com.sample.springelastic.domain.Article;

public class ArticleMapper {

    public static Article map(ArticleRequest request) {
        Article article = new Article();
        article.setName(request.getName());
        article.setTitle(request.getTitle());
        article.setAuthor(request.getAuthor());
        article.setPrice(request.getPrice());
        return article;
    }
}
