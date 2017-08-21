package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "article")
public class Article {
	
	@Id
    public String articleId;

    public String title;
    public String articleContent;
    
    
    public Article() {}

    public Article(String title, String articleContent) {
        this.title = title;
        this.articleContent = articleContent;
    }
    
    
    public String toString() {
        return String.format(
                "Article[articleId=%s, title='%s', articleContent='%s']",
                articleId, title, articleContent);
    }



}
