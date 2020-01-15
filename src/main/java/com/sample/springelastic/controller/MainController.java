package com.sample.springelastic.controller;

import com.sample.springelastic.domain.Article;
import com.sample.springelastic.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private ArticleRepository repository;

    @Autowired
    public MainController(ArticleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/api/article")
    public void post(@RequestBody ArticleRequest request) {
        Article article = ArticleMapper.map(request);
        repository.save(article);
    }
}
