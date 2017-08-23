package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Article;

public interface ArticleRepository extends MongoRepository<Article, String>{
	
	 public Article findByTitle(String title);
	 public List<Article> findByArticleContent(String articleContent);
	
}
