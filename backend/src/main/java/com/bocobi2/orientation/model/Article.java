package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "article")
public class Article {
	
	@Id
    public String articleId;
    private String title;
    
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}


	private String articleContent;
    
    
    public Article() {}

    public Article(String title, String articleContent) {
        this.title = title;
        this.articleContent = articleContent;
    }
    
    
    @Override
    public String toString() {
        return String.format(
                "{\"articleId\":%s, \"title\":'%s'}",
                articleId, title);
    }


}
