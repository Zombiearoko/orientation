package com.bocobi2.orientation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bocobi2.orientation.model.*;
import com.bocobi2.orientation.repositories.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	AdminRepository adminRepository;
	
	
	//methode pour la gestion de la connexion de l'administrateur
	
	@RequestMapping(value="/authentication",method={RequestMethod.GET,RequestMethod.POST}, params={"title","articleContent"})
	public JSONObject authentication(HttpServletRequest request){
		
		HttpSession session;
		JSONObject result,success,errors; 
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();
		
		//parametres de la requete
		String welcomeMessage = "";
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Admin admin = null;
		
		try{
			validateLogin(login);
		}catch(Exception e){
			errors.put("loginErrorMessage", e.getMessage());
		}
		
		try{
			validatePassword(password);
		}catch(Exception e){
			errors.put("passwordErrorMessage", e.getMessage());
		}
		try{
			admin = new Admin()
			admin = adminRepository.findByLogin(login);
		}catch(Exception e){
			errors.put("notFoundError", "l'administrateur de login " +login+" n'existe pas!");
		}
		if(errors.isEmpty()){
			if(admin.getLogin().equals(login) && admin.getPassword().equals(password)){
				session = request.getSession();
				welcomeMessage = "session ouverte avec succes, bienvenu Mr l'administrateur";
				session.setAttribute("welcomeMessage", welcomeMessage);
				success.put("rapport", "connexion reussie");
				success.put("welcomeMessage", welcomeMessage);
			}else{
				errors.put("errorMessage", "le mot de passe saisi ne corespond pas au login saisi");
			}
		}
		result.put("success", success);
		result.put("errors", errors);
		return result;
		
	}
	
	//methode pour la creation d'un nouvel article
	
	@RequestMapping(value="/createArticle",method={RequestMethod.GET, RequestMethod.POST}, params={"title","articleContent"})
	public JSONObject createArticle(HttpServletRequest request){
		
		Article article;
		JSONObject result,success,errors; 
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();
		String title = request.getParameter("title");
		String articleContent = request.getParameter("articleContent");
		
		try{
			validateTitle(title);
		}catch(Exception e){
			errors.put("titleError", e.getMessage());
		}
		try{
			validateArticleContent(articleContent);
		}catch(Exception e){
			errors.put("articleContentError", e.getMessage());
		}
		
		if(errors.isEmpty()){
			try{
				article = new Article(title,articleContent);
				articleRepository.save(article);
				success.put("rapport", "enregistrement reussi avec succes");
			}catch(Exception e){
				e.printStackTrace();
				errors.put("insertionError", "echec de l'insertion dans la base de donnée!"+e.getMessage());
			}
		}
		
		result.put("success", success);
		result.put("errors", errors);
		return result;
		
	}
	
	//methodes de controle des formulaires
	private void validateArticleContent(String articleContent)throws Exception {
		// TODO Auto-generated method stub
		if(articleContent.length()<50){
			throw new Exception("le contenu de l'article doit avoir un minimum de 50 caracteres");
		}
	}
	private void validateTitle(String title)throws Exception {
		// TODO Auto-generated method stub
		if(title.length()==0){
			throw new Exception("le titre ne peux pas etre vide");
		}
	}
	
	private void validatePassword(String password) throws Exception {
		if ( password != null ) {
			if ( password.length() < 8 ) {
				throw new Exception( "Le mot de passe doit contenir au moins 8 caractères." );
			}
		} else {
		throw new Exception( "Merci de saisir votre mot de passe." );
		} 	
	}
	private void validateLogin(String login) {
		// TODO Auto-generated method stub
		if ( login != null ) {
			if ( login.length() < 8 ) {
				throw new Exception( "Le login doit contenir au moins 8 caractères." );
			}
		} else {
		throw new Exception( "Merci de saisir votre login." );
		} 
	}
	
}