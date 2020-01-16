package com.sample.springelastic.service.impl;

import com.sample.springelastic.domain.Article;
import com.sample.springelastic.repository.ArticleRepository;
import com.sample.springelastic.service.ArticleService;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.RegexpQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultArticleService implements ArticleService {

    private ArticleRepository repository;

    @Autowired
    public DefaultArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Article> searchArticleByTitle(String title) {
        List<Article> articles = new ArrayList<>();
        MatchQueryBuilder matchQuery = QueryBuilders.matchQuery("title", title);
        repository.search(matchQuery).forEach(articles::add);
        return articles;
    }

    @Override
    public List<Article> searchArticleByName(String name) {
        List<Article> articles = new ArrayList<>();
        RegexpQueryBuilder queryBuilder = QueryBuilders.regexpQuery("name", name);
        Iterable<Article> result = repository.search(queryBuilder);
        result.forEach(articles::add);
        return articles;
    }

    @Override
    public List<Article> searchArticleByPriceRange(int begin, int end) {
        List<Article> articles = new ArrayList<>();
        RangeQueryBuilder queryBuilder = QueryBuilders.rangeQuery("price")
                .from(begin)
                .to(end);
        Iterable<Article> result = repository.search(queryBuilder);
        result.forEach(articles::add);
        return articles;
    }
}
