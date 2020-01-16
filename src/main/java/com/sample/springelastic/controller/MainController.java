package com.sample.springelastic.controller;

import com.sample.springelastic.domain.Article;
import com.sample.springelastic.repository.ArticleRepository;
import com.sample.springelastic.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private ArticleRepository repository;
    private ArticleService service;

    @Autowired
    public MainController(ArticleRepository repository, ArticleService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/api/article/{title}")
    public List<Article> searchArticleByTitle(@PathVariable("title") String title) {
        return service.searchArticleByTitle(title);
    }

    @GetMapping("/api/article/byName/{name}")
    public List<Article> searchArticleByName(@PathVariable("name") String name) {
        return service.searchArticleByName(name);
    }

    @GetMapping("/api/article/byPrice/{from}/{to}")
    public List<Article> searchArticleByName(@PathVariable("from") int from,
                                             @PathVariable("to") int to) {
        return service.searchArticleByPriceRange(from, to);
    }

    @PostMapping("/api/article")
    public void post(@RequestBody ArticleRequest request) {
        Article article = ArticleMapper.map(request);
        repository.save(article);
    }
}
