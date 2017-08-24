package com.bocobi2.orientation.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
	
	String booksFolder ="D:/workspacegithub/orientation/backend/src/main/resources/booksFolder";
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	AdministratorRepository administratorRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	
	//methode pour la gestion de la connexion de l'administrateur en get
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/authentication", method=RequestMethod.GET, params={"login","password"})
	public JSONObject authenticationGet(HttpServletRequest request){
		
		//creation des objects JSON à renvoyer à la vue
		
		JSONObject result,success,errors; 
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();
		
		//recuperation des parametres de la requete
		
		String welcomeMessage = "";
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		//objets utils
		
		HttpSession session;
		
		//creation d'un objet administrateur
		
		Administrator admin = new Administrator();;
		
		//recheche dans la base de données de l'administrateur ayant les informations fournies
		
		try{
			System.out.println("recherche de l'administrateur dans la base de donnees");
			admin = administratorRepository.findByLogin(login);
			System.out.println("recherche reussie: administrateur trouvé");
		}catch(Exception e){
			errors.put("notFoundError", "l'administrateur de login " +login+" n'existe pas!"+e.getMessage());
			System.out.print(e.getMessage());
		}
		if(errors.isEmpty()){
			
			if(admin.getLogin().equals(login) && admin.getPassword().equals(password)){
				session = request.getSession();
				session.setAttribute("welcomeMessage", welcomeMessage);
				success.put("rapport", "connexion reussie");
			}else{
				errors.put("errorMessage", "le mot de passe saisi ne corespond pas au login saisi");
			}
		}
		result.put("success", success);
		result.put("errors", errors);
		return result;
		
	}
	
	
	
	//methode pour la gestion de la connexion de l'administrateur en post
	
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/authentication", method=RequestMethod.POST, params={"login","password"})
		public JSONObject authenticationPost(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();
			
			//recuperation des parametres de la requete
			
			String welcomeMessage = "";
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			//objets utils
			
			HttpSession session;
			
			//creation d'un objet administrateur
			
			Administrator admin = new Administrator();;
			
			//recheche dans la base de données de l'administrateur ayant les informations fournies
			
			try{
				System.out.println("recherche de l'administrateur dans la base de donnees");
				admin = administratorRepository.findByLogin(login);
				System.out.println("recherche reussie: administrateur trouvé");
			}catch(Exception e){
				errors.put("notFoundError", "l'administrateur de login " +login+" n'existe pas!"+e.getMessage());
				System.out.print(e.getMessage());
			}
			if(errors.isEmpty()){
				
				if(admin.getLogin().equals(login) && admin.getPassword().equals(password)){
					session = request.getSession();
					session.setAttribute("welcomeMessage", welcomeMessage);
					success.put("rapport", "connexion reussie");
				}else{
					errors.put("errorMessage", "le mot de passe saisi ne corespond pas au login saisi");
				}
			}
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}
	
	
	
	
	//methode pour la creation d'un nouvel article en get
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/createArticle", method=RequestMethod.GET, params={"title","articleContent"})
	public JSONObject createArticleGet(HttpServletRequest request){
		
		//creation des objects JSON à renvoyer à la vue
		
		JSONObject result,success,errors; 
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();
		
		//recuperation des parametres de la requete
		
		String title = request.getParameter("title");
		String articleContent = request.getParameter("articleContent");
		
		//creation de l'article
		
		Article article = new Article(title,articleContent);
		
		//insertion de l'article dans la base de données

			try{
				articleRepository.save(article);
				success.put("rapport", "article enregistré avec succes");
			}catch(Exception e){
				errors.put("insertionError", "echec de l'insertion dans la base de donnée!");
			}
		
		
		result.put("success", success);
		result.put("errors", errors);
		return result;
		
	}
	
	
	
	
	//methode pour la creation d'un nouvel article en post
	
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/createArticle", method=RequestMethod.POST, params={"title","articleContent"})
		public JSONObject createArticlePost(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();
			
			//recuperation des parametres de la requete
			
			String title = request.getParameter("title");
			String articleContent = request.getParameter("articleContent");
			
			//creation de l'article
			
			Article article = new Article(title,articleContent);
			
			//insertion de l'article dans la base de données

				try{
					articleRepository.save(article);
					success.put("rapport", "article enregistré avec succes");
				}catch(Exception e){
					errors.put("insertionError", "echec de l'insertion dans la base de donnée!");
				}
			
			
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}
		
		
		
		//methode pour l'ajout d'un livre en get
		
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/addBook",method=RequestMethod.GET)
		public JSONObject addBookGet(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();
			
			//recuperation des parametres de la requete
			
			String bookName = request.getParameter("bookName");
			String bookAuthor = request.getParameter("bookAuthor");
			String bookEdition = request.getParameter("bookEdition");
			Part bookFile=null;
			try {
				bookFile = request.getPart("bookFile");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//definition du nom que aura le fichier recuperé dans mon repertoire de livre
			
			String fileName = bookName+".pdf";
			
			// definition logique du repertoire d'enregistrement des livres
			
			File booksRepository = new File(booksFolder);
			if(!booksRepository.exists()){
				booksRepository.mkdir();
			}

			String nameOnTheDisk = booksFolder+File.separator+fileName;
			
			try{
				bookFile.write(nameOnTheDisk);
			}catch(Exception e){
				errors.put("noMoreSpaceError", "le fichier n'a pas pu etre sauvegadé sur le disque");
			}
			//creation du livre
			
			Book book = new Book(bookName,bookAuthor,bookEdition,nameOnTheDisk);
			
			//insertion du livre dans la base de données
				if(errors.isEmpty()){
				try{
					bookRepository.save(book);
					success.put("rapport", "livre enregistré avec succès");
					
				}catch(Exception e){
					errors.put("notSaveError", "le livre a été enregistré sur le disque mais son nom n'a pas"
							+ "été enregistré dans la base de données");
				}
				}
			
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}
	//methode pour l'ajout d'un livre en post
	
			@SuppressWarnings("unchecked")
			@RequestMapping(value="/addBook",method=RequestMethod.POST)
			public JSONObject addBookPost(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
				
				//recuperation des parametres de la requete
				
				String bookName = request.getParameter("bookName");
				String bookAuthor = request.getParameter("bookAuthor");
				String bookEdition = request.getParameter("bookEdition");
				Part bookFile=null;
				try {
					bookFile = request.getPart("bookFile");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ServletException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//definition du nom que aura le fichier recuperé dans mon repertoire de livre
				
				String fileName = bookName+".pdf";
				
				// definition logique du repertoire d'enregistrement des livres
				
				File booksRepository = new File(booksFolder);
				if(!booksRepository.exists()){
					booksRepository.mkdir();
				}

				String nameOnTheDisk = booksFolder+File.separator+fileName;
				
				try{
					bookFile.write(nameOnTheDisk);
				}catch(Exception e){
					errors.put("noMoreSpaceError", "le fichier n'a pas pu etre sauvegadé sur le disque");
				}
				//creation du livre
				
				Book book = new Book(bookName,bookAuthor,bookEdition,nameOnTheDisk);
				
				//insertion du livre dans la base de données
					if(errors.isEmpty()){
					try{
						bookRepository.save(book);
						success.put("rapport", "livre enregistré avec succès");
						
					}catch(Exception e){
						errors.put("notSaveError", "le livre a été enregistré sur le disque mais son nom n'a pas"
								+ "été enregistré dans la base de données");
					}
					}
				
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
		

	//methodes de controle des formulaires
	
	
	
}
