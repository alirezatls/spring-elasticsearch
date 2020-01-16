package com.sample.springelastic.service;

import com.sample.springelastic.domain.Article;

import java.util.List;

public interface ArticleService {

    List<Article> searchArticleByTitle(String title);

    List<Article> searchArticleByName(String name);

    List<Article> searchArticleByPriceRange(int begin, int end);
}
