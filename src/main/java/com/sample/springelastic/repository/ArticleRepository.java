package com.sample.springelastic.repository;


import com.sample.springelastic.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article,String> {
}
