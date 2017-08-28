package com.bocobi2.orientation.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bocobi2.orientation.model.Administrator;
import com.bocobi2.orientation.model.Article;
import com.bocobi2.orientation.model.Book;
import com.bocobi2.orientation.model.ErrorClass;
import com.bocobi2.orientation.model.Scholarship;
import com.bocobi2.orientation.model.SchoolCalender;
import com.bocobi2.orientation.repositories.AdministratorRepository;
import com.bocobi2.orientation.repositories.ArticleRepository;
import com.bocobi2.orientation.repositories.BookRepository;
import com.bocobi2.orientation.repositories.ScholarshipRepository;
import com.bocobi2.orientation.repositories.SchoolCalenderRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/administrator")
public class AdministratorController {
	
	public static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	AdministratorRepository administratorRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	SchoolCalenderRepository schoolCalenderRepository;
	
	@Autowired
	ScholarshipRepository scholarshipRepository;
	
	
	String booksFolder ="D:/workspacegithub/orientation/backend/src/main/resources/booksFolder";
	String schoolCalenderFolder = "D:/workspacegithub/orientation/backend/src/main/resources/schoolCalenderFolder";

	
//***************************************************************************************************************	
	//******************************************************************************//
	//***********************methode d'authentification******************************//
	//******************************************************************************//
	
	//methode pour la gestion de la connexion de l'administrateur en get

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/authentication", method=RequestMethod.GET, params={"login","password"})
	public ResponseEntity<?> authenticationGet(HttpServletRequest request){
		
		//recuperation des parametres de la requete
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		//objets utils
		
		HttpSession session;
		
		//creation d'un objet administrateur
		
		Administrator admin = new Administrator();
		
		//recheche dans la base de données de l'administrateur ayant les informations fournies
		logger.info("recherche de l'administrateur"+admin);
			admin = administratorRepository.findByLogin(login);
		if(admin==null){
			logger.error("l'administrateur de login {} n'existe pas!",login);
			return new ResponseEntity(new ErrorClass("l'administrateur de login "
					+ login +" n'existe pas!"),HttpStatus.NOT_FOUND);
		}
			if(admin.getLogin().equals(login) && admin.getPassword().equals(password)){
				session = request.getSession();
				session.setAttribute("administratorInSession", admin);
			}else{
				logger.error("errorMessage", "le mot de passe saisi ne corespond pas au login saisi");
				return new ResponseEntity(new ErrorClass("le mot de passe saisi ne corespond pas au login saisi"),HttpStatus.NOT_ACCEPTABLE);
			}

		
		return new ResponseEntity<Administrator>(admin,HttpStatus.OK);
		
	}
	
	
	
	//methode pour la gestion de la connexion de l'administrateur en post
	
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/authentication", method=RequestMethod.POST, params={"login","password"})
		public ResponseEntity<?> authenticationPost(HttpServletRequest request){
			
			//recuperation des parametres de la requete
			
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			//objets utils
			
			HttpSession session;
			
			//creation d'un objet administrateur
			
			Administrator admin = new Administrator();
			
			//recheche dans la base de données de l'administrateur ayant les informations fournies
			logger.info("recherche de l'administrateur"+admin);
				admin = administratorRepository.findByLogin(login);
			if(admin==null){
				logger.error("l'administrateur de login {} n'existe pas!",login);
				return new ResponseEntity(new ErrorClass("l'administrateur de login "
						+ login +" n'existe pas!"),HttpStatus.NOT_FOUND);
			}
				if(admin.getLogin().equals(login) && admin.getPassword().equals(password)){
					session = request.getSession();
					session.setAttribute("administratorInSession", admin);
				}else{
					logger.error("errorMessage", "le mot de passe saisi ne corespond pas au login saisi");
					return new ResponseEntity(new ErrorClass("le mot de passe saisi ne corespond pas au login saisi"),HttpStatus.NOT_ACCEPTABLE);
				}

			
			return new ResponseEntity<Administrator>(admin,HttpStatus.OK);
			
		}	
//***************************************************************************************************************	
	//******************************************************************************//
	//***********************methode creation d'un nouvel article*******************//
	//******************************************************************************//

	
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
		
//***************************************************************************************************************
		//******************************************************************************//
		//***********************methode pour la mise a jour des articles**********//
		//******************************************************************************//		

		//methode pour la mise a jour des Articles en get
		

		@SuppressWarnings("unchecked")
		@RequestMapping(value="/updateArticle",method=RequestMethod.GET)
		public JSONObject updateArticleGet(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();

			//recuperation des parametres de la requete
			String title = request.getParameter("title"); 
			String newArticleContent = request.getParameter("newArticleContent");
			
			//creation de l'article à mettre à jour
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
			article = articleRepository.findByTitle(title);
					
					
				if(article==null){
					errors.put("notFoundError", "l'article de titre "+title+" n'existe pas!");
				}else{
					article.setArticleContent(newArticleContent);
					try{articleRepository.save(article);
					success.put("rapport", "mise à jour effectuée avec succes");
					}catch(Exception e){
						errors.put("error", "echec de la mise à jour, le serveur est arreté");
					}
					
				}
				
			
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}
		
		//methode pour la mise a jour des articles en post
		

		@SuppressWarnings("unchecked")
		@RequestMapping(value="/updateArticle",method=RequestMethod.POST)
		public JSONObject updateArticlePost(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();

			//recuperation des parametres de la requete
			String title = request.getParameter("title"); 
			String newArticleContent = request.getParameter("newArticleContent");
			
			//creation de l'article à mettre à jour
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
			article = articleRepository.findByTitle(title);
					
					
				if(article==null){
					errors.put("notFoundError", "l'article de titre "+title+" n'existe pas!");
				}else{
					article.setArticleContent(newArticleContent);
					try{articleRepository.save(article);
					success.put("rapport", "mise à jour effectuée avec succes");
					}catch(Exception e){
						errors.put("error", "echec de la mise à jour, le serveur est arreté");
					}
					
				}
				
			
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}
		
//***************************************************************************************************************
		//******************************************************************************//
		//***********************methode pour la suppression d'un article**********//
		//******************************************************************************//		

		
		//methode pour la suppression d'un article en get
		

		@SuppressWarnings("unchecked")
		@RequestMapping(value="/deleteArticle",method=RequestMethod.GET)
		public JSONObject deleteArticleGet(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();

			//recuperation des parametres de la requete
			
			String title =request.getParameter("title");
			//creation de l'article a supprimer
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
					article = articleRepository.findByTitle(title);
					
					
				if(article==null){
					errors.put("notFoundError", "l'article de titre "+title+" n'existe pas!");
				}else{
					articleRepository.deleteByArticleId(article.getArticleId());
					success.put("rapport", "suppression effectuée avec succes");
				}
				
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}
		
		//methode pour la suppression d'un article en post
		

		@SuppressWarnings("unchecked")
		@RequestMapping(value="/deleteArticle",method=RequestMethod.POST)
		public JSONObject deleteArticlePost(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();

			//recuperation des parametres de la requete
			
			String title =request.getParameter("title");
			//creation du livre a supprimer
			
			Article article = new Article();
			
			//recuperation du livre dans la base de données
				
					article = articleRepository.findByTitle(title);
					
					
				if(article==null){
					errors.put("notFoundError", "l'article de titre "+title+" n'existe pas!");
				}else{
					articleRepository.deleteByArticleId(article.getArticleId());
					success.put("rapport", "suppression effectuée avec succes");
				}
				
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}
//***************************************************************************************************************
		
		//******************************************************************************//
		//*************methode pour la recherche d'un article suivant le titre**********//
		//******************************************************************************//		
		
		//methode pour la recherche d'un article en get
		

		@SuppressWarnings("unchecked")
		@RequestMapping(value="/researchArticleByTitle",method=RequestMethod.GET)
		public JSONObject researchArticleByTitleGet(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();

			//recuperation des parametres de la requete
			
			String title =request.getParameter("title");
			//creation de l'article à renvoyer
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
					article = articleRepository.findByTitle(title);
					
					
				if(article==null){
					errors.put("notFoundError", "aucun article de titre "+title+" n'est enrégisté!");
				}else{
					success.put("article", article);

				}
			
			
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}
		
		
		//methode pour la recherche d'un article en get
		

		@SuppressWarnings("unchecked")
		@RequestMapping(value="/researchArticleByTitle",method=RequestMethod.POST)
		public JSONObject researchArticleByTitlePost(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();

			//recuperation des parametres de la requete
			
			String title =request.getParameter("title");
			//creation de l'article à renvoyer
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
					article = articleRepository.findByTitle(title);
					
					
				if(article==null){
					errors.put("notFoundError", "aucun article de titre "+title+" n'est enrégisté!");
				}else{
					success.put("article", article);

				}
			
			
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}


//***************************************************************************************************************
		
		//******************************************************************************//
		//***********************methode pour l'ajout d'un livre*******************//
		//******************************************************************************//		
		
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
			double bookPrice = Double.parseDouble(request.getParameter("bookPrice"));
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
			
			Book book = new Book(bookName,bookAuthor,bookEdition,bookPrice,nameOnTheDisk);
			
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
			double bookPrice = Double.parseDouble(request.getParameter("bookPrice"));
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
			
			Book book = new Book(bookName,bookAuthor,bookEdition,bookPrice,nameOnTheDisk);
			
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

		
//***************************************************************************************************************		
		//******************************************************************************//
		//***********************methode pour la recherche des livre par le nom du livre*******************//
		//******************************************************************************//		

			//methode pour la recherche des livre en get
			

			@SuppressWarnings("unchecked")
			@RequestMapping(value="/researchBookByName",method=RequestMethod.GET)
			public JSONObject researchBookByNameGet(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
	
				//recuperation des parametres de la requete
				
				String bookName =request.getParameter("bookName");
				//creation du livre
				
				Book book = new Book();
				
				//insertion du livre dans la base de données
					
						book = bookRepository.findByBookName(bookName);
						
						
					if(book==null){
						errors.put("notFoundError", "le livre de nom "+bookName+" n'existe pas!");
					}else{
						success.put("rapport", book);
					}
				
				
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
			//methode pour la recherche des livre en post
		

			@SuppressWarnings("unchecked")
			@RequestMapping(value="/researchBookByName",method=RequestMethod.POST)
			public JSONObject researchBookByNamePost(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
	
				//recuperation des parametres de la requete
				
				String bookName =request.getParameter("bookName");
				//creation du livre
				
				Book book = new Book();
				
				//recherche du livre dans la base de données
					
						book = bookRepository.findByBookName(bookName);
						
						
					if(book==null){
						errors.put("notFoundError", "le livre de nom "+bookName+" n'existe pas!");
					}else{
						success.put("rapport", book);
					}
				
				
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
//***************************************************************************************************************
			//******************************************************************************//
			//***********************methode pour la recherche de tous les livres**********//
			//******************************************************************************//		
			
			//methode pour la recherche de tous les livres en get
			

			@SuppressWarnings("unchecked")
			@RequestMapping(value="/researchAllBook",method=RequestMethod.GET)
			public JSONObject researchAllBookGet(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
	
				//creation de laliste des livres
				
				List<Book> listOfBook = new ArrayList<Book>();
				
				//recuperation des livres dans la base de données
					
						listOfBook = bookRepository.findAll();
						
						
					if(listOfBook.isEmpty()){
						errors.put("notFoundError", "aucun livre n'est enregistré dans la base de données");
					}else{
						int i=1;
						for(Book bookFind:listOfBook){
						success.put("book"+i, bookFind);
						i++;
						}
					}
				
				
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
			
			//methode pour la recherche de tous les livres en post
			

			@SuppressWarnings("unchecked")
			@RequestMapping(value="/researchAllBook",method=RequestMethod.POST)
			public JSONObject researchAllBookPost(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
	
				//creation de la liste des livres
				List<Book> listOfBook = new ArrayList<Book>();
				
				//insertion du livre dans la base de données
					
						listOfBook = bookRepository.findAll();
						
						
					if(listOfBook.isEmpty()){
						errors.put("notFoundError", "aucun livre n'est enregistré dans la base de données");
					}else{
						int i=1;
						for(Book bookFind:listOfBook){
						success.put("book"+i, bookFind);
						i++;
						}
					}
				
				
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
			
//***************************************************************************************************************
			
			//******************************************************************************//
			//***********************methode pour la recherche des livres par auteur**********//
			//******************************************************************************//		
			
			//methode pour la recherche des livre par auteur en get
			

			@SuppressWarnings("unchecked")
			@RequestMapping(value="/researchBookByAuthor",method=RequestMethod.GET)
			public JSONObject researchBookByAuthorGet(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
	
				//recuperation des parametres de la requete
				
				String bookAuthor =request.getParameter("bookAuthor");
				//creation de la liste des livres
				
				List<Book> listOfBook = new ArrayList<Book>();
				
				//recuperation des livres dans la base de données
					
						listOfBook = bookRepository.findByBookAuthor(bookAuthor);
						
						
					if(listOfBook.isEmpty()){
						errors.put("notFoundError", "aucun livre d'auteur "+bookAuthor+" n'est enrégisté!");
					}else{
						int i=1;
						for(Book bookFind:listOfBook){
						success.put("book"+i, bookFind);
						i++;
						}
					}
				
				
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
			
			
			//methode pour la recherche des livre par auteur en post
			

			@SuppressWarnings("unchecked")
			@RequestMapping(value="/researchBookByAuthor",method=RequestMethod.POST)
			public JSONObject researchBookByAuthorPost(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
	
				//recuperation des parametres de la requete
				
				String bookAuthor =request.getParameter("bookAuthor");
				//creation de la liste des livres
				
				List<Book> listOfBook = new ArrayList<Book>();
				
				//recuperation des livres dans la base de données
					
						listOfBook = bookRepository.findByBookAuthor(bookAuthor);
						
						
					if(listOfBook.isEmpty()){
						errors.put("notFoundError", "aucun livre d'auteur "+bookAuthor+" n'est enrégisté!");
					}else{
						int i=1;
						for(Book bookFind:listOfBook){
						success.put("book"+i, bookFind);
						i++;
						}
					}
				
				
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
			
//***************************************************************************************************************
			
			//******************************************************************************//
			//***********************methode pour la suppression d'un livre**********//
			//******************************************************************************//		

			
			//methode pour la suppression d'un livre en get
			

			@SuppressWarnings("unchecked")
			@RequestMapping(value="/deleteBook",method=RequestMethod.GET)
			public JSONObject deleteBookGet(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
	
				//recuperation des parametres de la requete
				
				String bookName =request.getParameter("bookName");
				//creation du livre a supprimer
				
				Book book = new Book();
				
				//recuperation du livre dans la base de données
					
						book = bookRepository.findByBookName(bookName);
						
						
					if(book==null){
						errors.put("notFoundError", "le livre de nom "+bookName+" n'existe pas!");
					}else{
						bookRepository.deleteByBookId(book.getBookId());
						success.put("rapport", "suppression effectuée avec succes");
					}
					
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
			
			//methode pour la suppression des livre en post
			

			@SuppressWarnings("unchecked")
			@RequestMapping(value="/deleteBook",method=RequestMethod.POST)
			public JSONObject deleteBookPost(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
	
				//recuperation des parametres de la requete
				
				String bookName =request.getParameter("bookName");
				//creation du livre a supprimer
				
				Book book = new Book();
				
				//recuperation du livre dans la base de données
					
						book = bookRepository.findByBookName(bookName);
						
						
					if(book==null){
						errors.put("notFoundError", "le livre de nom "+bookName+" n'existe pas!");
					}else{
						bookRepository.deleteByBookId(book.getBookId());
					}
					
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
//***************************************************************************************************************
			//******************************************************************************//
			//***********************methode pour la mise a jour des livres**********//
			//******************************************************************************//		

			//methode pour la mise a jour des livres en get
			

			@SuppressWarnings("unchecked")
			@RequestMapping(value="/updateBook",method=RequestMethod.GET)
			public JSONObject updateBookGet(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
	
				//recuperation des parametres de la requete
				String bookName = request.getParameter("bookName"); 
				double newBookPrice = Double.parseDouble(request.getParameter("newBookPrice"));
				
				//creation du livre a supprimer
				
				Book book = new Book();
				
				//recuperation du livre dans la base de données
					
						book = bookRepository.findByBookName(bookName);
						
						
					if(book==null){
						errors.put("notFoundError", "le livre de nom "+bookName+" n'existe pas!");
					}else{
						book.setBookPrice(newBookPrice);
						try{bookRepository.save(book);
						success.put("rapport", "mise à jour effectuée avec succes");
						}catch(Exception e){
							errors.put("error", "echec de la mise à jour, le serveur est arreté");
						}
						
					}
					
				
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
			
			//methode pour la mise a jour des livres en post
			

			@SuppressWarnings("unchecked")
			@RequestMapping(value="/updateBook",method=RequestMethod.POST)
			public JSONObject updateBookPost(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
	
				//recuperation des parametres de la requete
				String bookName = request.getParameter("bookName"); 
				double newBookPrice = Double.parseDouble(request.getParameter("newBookPrice"));
				
				//creation du livre a supprimer
				
				Book book = new Book();
				
				//recuperation du livre dans la base de données
					
						book = bookRepository.findByBookName(bookName);
						
						
					if(book==null){
						errors.put("notFoundError", "le livre de nom "+bookName+" n'existe pas!");
					}else{
						book.setBookPrice(newBookPrice);
						try{bookRepository.save(book);
						success.put("rapport", "mise à jour effectuée avec succes");
						}catch(Exception e){
							errors.put("error", "echec de la mise à jour, le serveur est arreté");
						}
						
					}
					
				
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}

			
//***************************************************************************************************************	
			//******************************************************************************//
			//***********************methode de deconnexion******************************//
			//******************************************************************************//
			
			//methode pour la gestion de la deconnexion de l'administrateur en get
			
			@SuppressWarnings("unchecked")
			@RequestMapping(value="/deconnection", method=RequestMethod.GET)
			public JSONObject deconnectionGet(HttpServletRequest request){
				
				//creation des objects JSON à renvoyer à la vue
				
				JSONObject result,success,errors; 
				result = new JSONObject();
				success = new JSONObject();
				errors = new JSONObject();
				
				//recuperation des parametres de la requete
				
				
				//objets utils
				
				HttpSession session;
				
				//creation d'un objet administrateur
				
				Administrator admin = new Administrator();;
				
				//recheche dans la base de données de l'administrateur ayant les informations fournies

						session = request.getSession();
						admin = (Administrator) session.getAttribute("administratorInSession");
						
						if(admin!=null){
						try{
							session.invalidate();
							success.put("rapport", "deconnexion reussie");
						}catch(Exception e){
							errors.put("errorMessage", "la session n'a pas pu etre fermé");
						}
						}else{
							errors.put("errorMessage", "aucune session n'est ouverte");
						}
				result.put("success", success);
				result.put("errors", errors);
				return result;
				
			}
			
			
			
			//methode pour la gestion de la connexion de l'administrateur en post
			
				@SuppressWarnings("unchecked")
				@RequestMapping(value="/deconnection", method=RequestMethod.POST)
				public JSONObject deconnectionPost(HttpServletRequest request){
					
					//creation des objects JSON à renvoyer à la vue
					
					JSONObject result,success,errors; 
					result = new JSONObject();
					success = new JSONObject();
					errors = new JSONObject();
					
					//recuperation des parametres de la requete
					
					
					//objets utils
					
					HttpSession session;
					
					//creation d'un objet administrateur
					
					Administrator admin = new Administrator();;
					
					//recheche dans la base de données de l'administrateur ayant les informations fournies

							session = request.getSession();
							admin = (Administrator) session.getAttribute("administratorInSession");
							
							if(admin!=null){
							try{
								session.invalidate();
								success.put("rapport", "deconnexion reussie");
							}catch(Exception e){
								errors.put("errorMessage", "la session n'a pas pu etre fermé");
							}
							}else{
								errors.put("errorMessage", "aucune session n'est ouverte");
							}
					result.put("success", success);
					result.put("errors", errors);
					return result;
					
				}			
//***************************************************************************************************************	

				
				
				

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
//***************************************************************************************************************	
				//******************************************************************************//
				//***********************methode creation d'un nouveau programme*******************//
//******************************************************************************//


		//methode pour la creation d'un nouvel article en get
		
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/addSchoolCalender", method=RequestMethod.GET)
		public JSONObject addSchoolCalenderGet(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();
			
			//recuperation des parametres de la requete
			
			String schoolCalenderName = request.getParameter("schoolCalenderName");
			String schoolCalenderType = request.getParameter("schoolCalenderType");
			String schoolCalenderYear = request.getParameter("schoolCalenderYear");
			Part schoolCalenderFile = null;
			try{
			schoolCalenderFile = request.getPart("schoolCalenderFile");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			String schoolCalenderFileName = schoolCalenderName+".pdf";
			
			//definition logique du repertoire d'enregistrement
			
			File fileRepository = new File(schoolCalenderFolder);
			if(!fileRepository.exists()){
				fileRepository.mkdir();
			}
			
			String nameOnTheDisk = schoolCalenderFolder+File.separator+schoolCalenderFileName;
			
			try{
				schoolCalenderFile.write(nameOnTheDisk);
				
			}catch(Exception e){
				errors.put("noMoreSpaceError", "le fichier n'a pas pu etre sauvegadé sur le disque");
			}
			//creation du programme
			
			SchoolCalender schoolCalender = new SchoolCalender(schoolCalenderName,
																schoolCalenderType,
																schoolCalenderYear,
																nameOnTheDisk);
			
			//insertion du livre dans la base de données
				if(errors.isEmpty()){
				try{
					 schoolCalenderRepository.save(schoolCalender);
					success.put("rapport", "programme enregistré avec succès");
					
				}catch(Exception e){
					errors.put("notSaveError", "le programme a été enregistré sur le disque mais son nom n'a pas"
							+ "été enregistré dans la base de données");
				}
				}
			
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}




		//methode pour la creation d'un nouvel article en post
		
				@SuppressWarnings("unchecked")
				@RequestMapping(value="/addSchoolCalender", method=RequestMethod.POST)
				public JSONObject createSchoolCalenderPost(HttpServletRequest request){
					
					//creation des objects JSON à renvoyer à la vue
					
					JSONObject result,success,errors; 
					result = new JSONObject();
					success = new JSONObject();
					errors = new JSONObject();
					
					//recuperation des parametres de la requete
					
					String schoolCalenderName = request.getParameter("schoolCalenderName");
					String schoolCalenderType = request.getParameter("schoolCalenderType");
					String schoolCalenderYear = request.getParameter("schoolCalenderYear");
					Part schoolCalenderFile = null;
					try{
					schoolCalenderFile = request.getPart("schoolCalenderFile");
					}catch(Exception e){
						e.printStackTrace();
					}
					
					String schoolCalenderFileName = schoolCalenderName+".pdf";
					
					//definition logique du repertoire d'enregistrement
					
					File fileRepository = new File(schoolCalenderFolder);
					if(!fileRepository.exists()){
						fileRepository.mkdir();
					}
					
					String nameOnTheDisk = schoolCalenderFolder+File.separator+schoolCalenderFileName;
					
					try{
						schoolCalenderFile.write(nameOnTheDisk);
						
					}catch(Exception e){
						errors.put("noMoreSpaceError", "le fichier n'a pas pu etre sauvegadé sur le disque");
					}
					//creation du programme
					
					SchoolCalender schoolCalender = new SchoolCalender(schoolCalenderName,
																		schoolCalenderType,
																		schoolCalenderYear,
																		nameOnTheDisk);
					
					//insertion du livre dans la base de données
						if(errors.isEmpty()){
						try{
							 schoolCalenderRepository.save(schoolCalender);
							success.put("rapport", "programme enregistré avec succès");
							
						}catch(Exception e){
							errors.put("notSaveError", "le programme a été enregistré sur le disque mais son nom n'a pas"
									+ "été enregistré dans la base de données");
						}
						}
					
					result.put("success", success);
					result.put("errors", errors);
					return result;
					
				}
	
//***************************************************************************************************************
	//******************************************************************************//
	//***********************methode pour la suppression d'un programme**********//
	//******************************************************************************//		

	
	//methode pour la suppression d'un programme en get
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/deleteSchoolCalender",method=RequestMethod.GET)
	public JSONObject deleteSchoolCalenderGet(HttpServletRequest request){
		
		//creation des objects JSON à renvoyer à la vue
		
		JSONObject result,success,errors; 
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();

		//recuperation des parametres de la requete
		
		String schoolCalenderName =request.getParameter("schoolCalenderName");
		//creation du programme à supprimer
		
		SchoolCalender schoolCalender = new SchoolCalender();
		
		//recuperation de l'article dans la base de données
			
				schoolCalender = schoolCalenderRepository.findBySchoolCalenderName(schoolCalenderName);
				
				
			if(schoolCalender==null){
				errors.put("notFoundError", "le programme de nom "+schoolCalenderName+" n'existe pas!");
			}else{
				schoolCalenderRepository.deleteByschoolCalenderId(schoolCalender.getSchoolCalenderId());
				success.put("rapport", "suppression effectuée avec succes");
			}
			
		result.put("success", success);
		result.put("errors", errors);
		return result;
		
	}
	
	//methode pour la suppression d'un programme en post
	

		@SuppressWarnings("unchecked")
		@RequestMapping(value="/deleteSchoolCalender",method=RequestMethod.POST)
		public JSONObject deleteSchoolCalenderPost(HttpServletRequest request){
			
			//creation des objects JSON à renvoyer à la vue
			
			JSONObject result,success,errors; 
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();

			//recuperation des parametres de la requete
			
			String schoolCalenderName =request.getParameter("schoolCalenderName");
			//creation du programme à supprimer
			
			SchoolCalender schoolCalender = new SchoolCalender();
			
			//recuperation de l'article dans la base de données
				
					schoolCalender = schoolCalenderRepository.findBySchoolCalenderName(schoolCalenderName);
					
					
				if(schoolCalender==null){
					errors.put("notFoundError", "le programme de nom "+schoolCalenderName+" n'existe pas!");
				}else{
					schoolCalenderRepository.deleteByschoolCalenderId(schoolCalender.getSchoolCalenderId());
					success.put("rapport", "suppression effectuée avec succes");
				}
				
			result.put("success", success);
			result.put("errors", errors);
			return result;
			
		}
		
//***************************************************************************************************************
	
	//******************************************************************************//
	//*************methode pour la recherche des programmes suivant l'année**********//
	//******************************************************************************//		
	
	//methode pour la recherche d'un programme en get
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/researchSchoolCalenderByYear",method=RequestMethod.GET)
	public JSONObject researchSchoolCalenderByYearGet(HttpServletRequest request){
		
		//creation des objects JSON à renvoyer à la vue
		
		JSONObject result,success,errors; 
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();

		//recuperation des parametres de la requete
		
		String schoolCalenderYear =request.getParameter("schoolCalenderyear");
		//creation de l'article à renvoyer
		
		List<SchoolCalender> listOfSchoolCalender = new ArrayList<SchoolCalender>();
		
		//recuperation de l'article dans la base de données
			
		listOfSchoolCalender = schoolCalenderRepository.findBySchoolCalenderYear(schoolCalenderYear);
				
			int i=1;	
			if(listOfSchoolCalender.isEmpty()){
				errors.put("notFoundError", "aucun programme pour le compte de l'année "+schoolCalenderYear+" n'est enrégisté!");
			}else{
				for(SchoolCalender sc:listOfSchoolCalender){
				success.put("programme"+i, sc);
				i++;
				}
			}
		
		
		result.put("success", success);
		result.put("errors", errors);
		return result;
		
	}
	

	//methode pour la recherche d'un programme en get
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/researchSchoolCalenderByYear",method=RequestMethod.POST)
	public JSONObject researchSchoolCalenderByYearPost(HttpServletRequest request){
		
		//creation des objects JSON à renvoyer à la vue
		
		JSONObject result,success,errors; 
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();

		//recuperation des parametres de la requete
		
		String schoolCalenderYear =request.getParameter("schoolCalenderyear");
		//creation de l'article à renvoyer
		
		List<SchoolCalender> listOfSchoolCalender = new ArrayList<SchoolCalender>();
		
		//recuperation de l'article dans la base de données
			
		listOfSchoolCalender = schoolCalenderRepository.findBySchoolCalenderYear(schoolCalenderYear);
				
			int i=1;	
			if(listOfSchoolCalender.isEmpty()){
				errors.put("notFoundError", "aucun programme pour le compte de l'année "+schoolCalenderYear+" n'est enrégisté!");
			}else{
				for(SchoolCalender sc:listOfSchoolCalender){
				success.put("programme"+i, sc);
				i++;
				}
			}
		
		
		result.put("success", success);
		result.put("errors", errors);
		return result;
		
	}


//***************************************************************************************************************

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//***************************************************************************************************************	
	//******************************************************************************//
	//***********************methode creation d'une nouvelle bourse*******************//
//******************************************************************************//


//methode pour la creation d'un nouvel article en get

@SuppressWarnings("unchecked")
@RequestMapping(value="/addScolarship", method=RequestMethod.GET)
public JSONObject addScolarshipGet(HttpServletRequest request){

//creation des objects JSON à renvoyer à la vue

JSONObject result,success,errors; 
result = new JSONObject();
success = new JSONObject();
errors = new JSONObject();

//recuperation des parametres de la requete

String scholarshipName = request.getParameter("scholarshipName");
String scholarshipType = request.getParameter("scholarshipType");
String scholarshipPublishingDate = request.getParameter("scholarshipPublishingDate");
String scholarshipExpirationDate = request.getParameter("scholarshipExpirationDate");
String scholarshipWebLink = request.getParameter("scholarshipWebLink");

//creation du programme

Scholarship scholarship = new Scholarship(scholarshipName,
											scholarshipType,
											scholarshipPublishingDate,
											scholarshipExpirationDate,
											scholarshipWebLink);

//insertion de la bourse dans la base de données
	try{
		 scholarshipRepository.save(scholarship);
		success.put("rapport", "bourse enregistrée avec succès");
		
	}catch(Exception e){
		errors.put("notSaveError", "echec de l'enregistrement de la bourse");
	}
	

result.put("success", success);
result.put("errors", errors);
return result;

}




//methode pour la creation d'une nouvelle bourse en post

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/addScolarship", method=RequestMethod.POST)
	public JSONObject addScolarshipPost(HttpServletRequest request){
		

		//creation des objects JSON à renvoyer à la vue

		JSONObject result,success,errors; 
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();

		//recuperation des parametres de la requete

		String scholarshipName = request.getParameter("scholarshipName");
		String scholarshipType = request.getParameter("scholarshipType");
		String scholarshipPublishingDate = request.getParameter("scholarshipPublishingDate");
		String scholarshipExpirationDate = request.getParameter("scholarshipExpirationDate");
		String scholarshipWebLink = request.getParameter("scholarshipWebLink");

		//creation du programme

		Scholarship scholarship = new Scholarship(scholarshipName,
													scholarshipType,
													scholarshipPublishingDate,
													scholarshipExpirationDate,
													scholarshipWebLink);

		//insertion de la bourse dans la base de données
			try{
				 scholarshipRepository.save(scholarship);
				success.put("rapport", "bourse enregistrée avec succès");
				
			}catch(Exception e){
				errors.put("notSaveError", "echec de l'enregistrement de la bourse");
			}
			

		result.put("success", success);
		result.put("errors", errors);
		return result;

		}
//***************************************************************************************************************
//******************************************************************************//
//***********************methode pour la suppression d'une bourse**********//
//******************************************************************************//		


//methode pour la suppression d'une bourse en get


@SuppressWarnings("unchecked")
@RequestMapping(value="/deleteScholarship",method=RequestMethod.GET)
public JSONObject deleteScholarshipGet(HttpServletRequest request){

//creation des objects JSON à renvoyer à la vue

JSONObject result,success,errors; 
result = new JSONObject();
success = new JSONObject();
errors = new JSONObject();

//recuperation des parametres de la requete

String scholarshipName =request.getParameter("scholarshipName");
//creation du programme à supprimer

Scholarship scholarship = new Scholarship();

//recuperation de la bourse dans la base de données

scholarship = scholarshipRepository.findByScholarshipName(scholarshipName);
	
	
if(scholarship==null){
	errors.put("notFoundError", "la bourse de nom "+scholarshipName+" n'existe pas!");
}else{
	schoolCalenderRepository.deleteByschoolCalenderId(scholarship.getScholarshipId());
	success.put("rapport", "suppression effectuée avec succes");
}

result.put("success", success);
result.put("errors", errors);
return result;

}

//methode pour la suppression d'une bourse en post


@SuppressWarnings("unchecked")
@RequestMapping(value="/deleteScholarship",method=RequestMethod.POST)
public JSONObject deleteScholarshipPost(HttpServletRequest request){

	//creation des objects JSON à renvoyer à la vue

	JSONObject result,success,errors; 
	result = new JSONObject();
	success = new JSONObject();
	errors = new JSONObject();

	//recuperation des parametres de la requete

	String scholarshipName =request.getParameter("scholarshipName");
	//creation du programme à supprimer

	Scholarship scholarship = new Scholarship();

	//recuperation de la bourse dans la base de données

	scholarship = scholarshipRepository.findByScholarshipName(scholarshipName);
		
		
	if(scholarship==null){
		errors.put("notFoundError", "la bourse de nom "+scholarshipName+" n'existe pas!");
	}else{
		schoolCalenderRepository.deleteByschoolCalenderId(scholarship.getScholarshipId());
		success.put("rapport", "suppression effectuée avec succes");
	}

	result.put("success", success);
	result.put("errors", errors);
	return result;

	}

//***************************************************************************************************************

//******************************************************************************//
//*************methode pour la recherche des bourses suivant le type**********//
//******************************************************************************//		

//methode pour la recherche des bourses en get


@SuppressWarnings("unchecked")
@RequestMapping(value="/researchScholarshipByType",method=RequestMethod.GET)
public JSONObject researchScholarshipByTypeGet(HttpServletRequest request){

//creation des objects JSON à renvoyer à la vue

JSONObject result,success,errors; 
result = new JSONObject();
success = new JSONObject();
errors = new JSONObject();

//recuperation des parametres de la requete

String scholarshipType =request.getParameter("scholarshipType");
//creation de la liste des bourses trouvées

List<Scholarship> listOfScholarship = new ArrayList<Scholarship>();

//recuperation de l'article dans la base de données

listOfScholarship = scholarshipRepository.findByScholarshipType(scholarshipType);
	
int i=1;	
if(listOfScholarship.isEmpty()){
	errors.put("notFoundError", "aucune bourse "+scholarshipType+" n'est enrégisté!");
}else{
	for(Scholarship sc:listOfScholarship){
	success.put("bourse"+i, sc);
	i++;
	}
}


result.put("success", success);
result.put("errors", errors);
return result;

}


//methode pour la recherche des bourses en get


@SuppressWarnings("unchecked")
@RequestMapping(value="/researchScholarshipByType",method=RequestMethod.POST)
public JSONObject researchScholarshipByTypePost(HttpServletRequest request){

	//creation des objects JSON à renvoyer à la vue

	JSONObject result,success,errors; 
	result = new JSONObject();
	success = new JSONObject();
	errors = new JSONObject();

	//recuperation des parametres de la requete

	String scholarshipType =request.getParameter("scholarshipType");
	//creation de la liste des bourses trouvées

	List<Scholarship> listOfScholarship = new ArrayList<Scholarship>();

	//recuperation de l'article dans la base de données

	listOfScholarship = scholarshipRepository.findByScholarshipType(scholarshipType);
		
	int i=1;	
	if(listOfScholarship.isEmpty()){
		errors.put("notFoundError", "aucune bourse "+scholarshipType+" n'est enrégisté!");
	}else{
		for(Scholarship sc:listOfScholarship){
		success.put("bourse"+i, sc);
		i++;
		}
	}


	result.put("success", success);
	result.put("errors", errors);
	return result;

	}

//***************************************************************************************************************


	//methodes de controle des formulaires
	
	
}
