package com.bocobi2.orientation.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bocobi2.orientation.model.*;
import com.bocobi2.orientation.repositories.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
	
	JSONObject result,success,errors; 
	ArticleRepository articleRepository;
	@RequestMapping(value="/createArticle",method=RequestMethod.POST, params={"title","articleContent"})
	public JSONObject createArticle(HttpServletRequest request){
		
		Article article;
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();
		String title = request.getParameter("title");
		String articleContent = request.getParameter("aticleContent");
		
		try{
			validateTilte(title);
		}catch(Exception e){
			errors.put("titleError", e.getMessage());
		}
		try{
			validateArticleContent(articleContent);
		}catch(Exception e){
			errors.put("articleError", e.getMessage());
		}
		
		if(errors.isEmpty()){
			try{
				article = new Article(title,articleContent);
				articleRepository.save(article);
			}catch(Exception e){
				errors.put("insertionError", "echec de l'insertion dans la base de donnée!");
			}
		}
		
		result.put("success", success);
		result.put("errors", errors);
		return result;
		
	}
	private void validateArticleContent(String articleContent)throws Exception {
		// TODO Auto-generated method stub
		if(articleContent.trim().length()<50){
			throw new Exception("le contenu de l'article doit avoir un minimum de 50 caracteres");
		}
	}
	private void validateTilte(String title)throws Exception {
		// TODO Auto-generated method stub
		if(title.length()==0){
			throw new Exception("le titre ne peux pas etre vide");
		}
		
		
	}
}
