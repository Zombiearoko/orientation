package com.bocobi2.orientation.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
import com.bocobi2.orientation.model.MailSender;
import com.bocobi2.orientation.model.Newsletter;
import com.bocobi2.orientation.model.NewsletterConcern;
import com.bocobi2.orientation.model.Scholarship;
import com.bocobi2.orientation.model.SchoolCalender;
import com.bocobi2.orientation.model.SuccessClass;
import com.bocobi2.orientation.repositories.AdministratorRepository;
import com.bocobi2.orientation.repositories.ArticleRepository;
import com.bocobi2.orientation.repositories.BookRepository;
import com.bocobi2.orientation.repositories.NewsletterConcernRepository;
import com.bocobi2.orientation.repositories.NewsletterRepository;
import com.bocobi2.orientation.repositories.ScholarshipRepository;
import com.bocobi2.orientation.repositories.SchoolCalenderRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orientation/administrator")
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
	
	@Autowired
	NewsletterRepository newsletterRepository;
	
	@Autowired
	NewsletterConcernRepository newsletterConcernRepository;
	
	//@Autowired
	MailSender mailSender;
	

	
	String booksFolder ="D:/workspacegithub/orientation/backend/src/main/resources/booksFolder";
	String schoolCalenderFolder = "D:/workspacegithub/orientation/backend/src/main/resources/schoolCalenderFolder";

	String newsletterSubject = "newsletter orientation";
	
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
					+ login +" n'existe pas!"),HttpStatus.OK);
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
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
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
						+ login +" n'existe pas!"),HttpStatus.OK);
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/createArticle", method=RequestMethod.GET, params={"title","articleContent"})
	public ResponseEntity<?> createArticleGet(HttpServletRequest request){

		
		//recuperation des parametres de la requete
		
		String title = request.getParameter("title");
		String articleContent = request.getParameter("articleContent");
		
		//creation de l'article
		
		Article article = new Article(title,articleContent);
		
		//insertion de l'article dans la base de données

			if(articleRepository.findByTitle(title)==null){
				articleRepository.save(article);
				return new ResponseEntity(new SuccessClass("article enregistré avec succes"),HttpStatus.OK);
			}else{
				logger.error("echec de l'insertion dans la base de donnée!");
				return new ResponseEntity(new ErrorClass("l'article de titre"
						+ title+" existe deja!"),HttpStatus.OK);
			}
		
		}
	
	
	
	
	//methode pour la creation d'un nouvel article en post
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/createArticle", method=RequestMethod.POST, params={"title","articleContent"})
		public ResponseEntity<?> createArticlePost(HttpServletRequest request){
			
			//recuperation des parametres de la requete
			
			String title = request.getParameter("title");
			String articleContent = request.getParameter("articleContent");
			
			//creation de l'article
			
			Article article = new Article(title,articleContent);
			
			//insertion de l'article dans la base de données

				if(articleRepository.findByTitle(title)==null){
					articleRepository.save(article);
					return new ResponseEntity(new SuccessClass("article enregistré avec succes"),HttpStatus.OK);
				}else{
					logger.error("echec de l'insertion dans la base de donnée!");
					return new ResponseEntity(new ErrorClass("l'article de titre"
							+ title+" existe deja!"),HttpStatus.OK);
				}
			
			}
		
				
//***************************************************************************************************************
		//******************************************************************************//
		//***********************methode pour la mise a jour des articles**********//
		//******************************************************************************//		

		//methode pour la mise a jour des Articles en get
		

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/updateArticle",method=RequestMethod.GET)
		public ResponseEntity<?> updateArticleGet(HttpServletRequest request){
			

			//recuperation des parametres de la requete
			String title = request.getParameter("title"); 
			String newArticleContent = request.getParameter("newArticleContent");
			
			//creation de l'article à mettre à jour
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
			article = articleRepository.findByTitle(title);
					
					
				if(article==null){
					logger.error("l'article de titre "+title+" n'existe pas!");
					return new ResponseEntity (new ErrorClass("l'article de titre"
							+ " "+title+" n'existe pas!"),HttpStatus.OK);
				}else{
					article.setArticleContent(newArticleContent);
					try{
						articleRepository.save(article);
						return new ResponseEntity(new SuccessClass("mise"
								+ " à jour effectuée avec succes"),HttpStatus.OK);
					}catch(Exception e){
						logger.error("echec de la mise à jour, le serveur est arreté");
						return new ResponseEntity(new ErrorClass("echec"
								+ " de la mise à jour, le serveur est arreté"),HttpStatus.NO_CONTENT);
					}
					
				}
				
			
		}
		
		//methode pour la mise a jour des articles en post
		

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/updateArticle",method=RequestMethod.POST)
		public ResponseEntity<?> updateArticlePost(HttpServletRequest request){
			
			//recuperation des parametres de la requete
			String title = request.getParameter("title"); 
			String newArticleContent = request.getParameter("newArticleContent");
			
			//creation de l'article à mettre à jour
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
			article = articleRepository.findByTitle(title);
					
					
				if(article==null){
					logger.error("l'article de titre "+title+" n'existe pas!");
					return new ResponseEntity (new ErrorClass("l'article de titre"
							+ " "+title+" n'existe pas!"),HttpStatus.OK);
				}else{
					article.setArticleContent(newArticleContent);
					try{
						articleRepository.save(article);
						return new ResponseEntity(new SuccessClass("mise"
								+ " à jour effectuée avec succes"),HttpStatus.OK);
					}catch(Exception e){
						logger.error("echec de la mise à jour, le serveur est arreté");
						return new ResponseEntity(new ErrorClass("echec"
								+ " de la mise à jour, le serveur est arreté"),HttpStatus.NO_CONTENT);
					}
					
				}
				
			
		}
		
//***************************************************************************************************************
		//******************************************************************************//
		//***********************methode pour la suppression d'un article**********//
		//******************************************************************************//		

		
		//methode pour la suppression d'un article en get
		

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/deleteArticle",method=RequestMethod.GET)
		public ResponseEntity<?> deleteArticleGet(HttpServletRequest request){
			

			//recuperation des parametres de la requete
			
			String title =request.getParameter("title");
			//creation de l'article a supprimer
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
					article = articleRepository.findByTitle(title);
					
					
				if(article==null){
					logger.error("l'article de titre "+title+" n'existe pas!");
					return new ResponseEntity (new ErrorClass("l'article de"
							+ " titre "+title+" n'existe pas!"),HttpStatus.OK);
				}else{
					articleRepository.deleteByArticleId(article.getArticleId());
					return new ResponseEntity (new SuccessClass("suppression "
							+ "effectuée avec succes"),HttpStatus.OK);
				}
				
		}
		
		//methode pour la suppression d'un article en post
		

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/deleteArticle",method=RequestMethod.POST)
		public ResponseEntity<?> deleteArticlePost(HttpServletRequest request){
			

			//recuperation des parametres de la requete
			
			String title =request.getParameter("title");
			//creation de l'article a supprimer
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
					article = articleRepository.findByTitle(title);
					
					
				if(article==null){
					logger.error("l'article de titre "+title+" n'existe pas!");
					return new ResponseEntity (new ErrorClass("l'article de"
							+ " titre "+title+" n'existe pas!"),HttpStatus.OK);
				}else{
					articleRepository.deleteByArticleId(article.getArticleId());
					return new ResponseEntity (new SuccessClass("suppression "
							+ "effectuée avec succes"),HttpStatus.OK);
				}
				
		}
		
//***************************************************************************************************************
		
		//******************************************************************************//
		//*************methode pour la recherche d'un article suivant le titre**********//
		//******************************************************************************//		
		
		//methode pour la recherche d'un article en get
		

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/researchArticleByTitle",method=RequestMethod.GET)
		public ResponseEntity<?> researchArticleByTitleGet(HttpServletRequest request){
			


			//recuperation des parametres de la requete
			
			String title =request.getParameter("title");
			//creation de l'article à renvoyer
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
			article = articleRepository.findByTitle(title);
					
					
			if(article==null){
				logger.error("aucun article de titre "+title+" n'est enrégisté!");
				return new ResponseEntity (new ErrorClass("aucun article de titre "
						+title+" n'est enrégisté!"),HttpStatus.OK);
			}else{
				return new ResponseEntity<Article>(article,HttpStatus.OK);

			}
			

		}
		
		
		//methode pour la recherche d'un article en post
		

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/researchArticleByTitle",method=RequestMethod.POST)
		public ResponseEntity<?> researchArticleByTitlePost(HttpServletRequest request){
			

			//recuperation des parametres de la requete
			
			String title =request.getParameter("title");
			//creation de l'article à renvoyer
			
			Article article = new Article();
			
			//recuperation de l'article dans la base de données
				
			article = articleRepository.findByTitle(title);
					
					
			if(article==null){
				logger.error("aucun article de titre "+title+" n'est enrégisté!");
				return new ResponseEntity (new ErrorClass("aucun article de titre "
						+title+" n'est enrégisté!"),HttpStatus.OK);
			}else{
				return new ResponseEntity<Article>(article,HttpStatus.OK);

			}
			

		}


//***************************************************************************************************************
		
		//******************************************************************************//
		//***********************methode pour l'ajout d'un livre*******************//
		//******************************************************************************//		
		
		//methode pour l'ajout d'un livre en get
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/addBook",method=RequestMethod.GET)
		public ResponseEntity<?> addBookGet(HttpServletRequest request){
			
			
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
				logger.error("le fichier n'a pas pu etre sauvegadé sur le disque");
				return new ResponseEntity(new ErrorClass("le fichier n'a pas pu "
						+ "etre sauvegadé sur le disque"),HttpStatus.OK);
			}
			//creation du livre
			
			Book book = new Book(bookName,bookAuthor,bookEdition,bookPrice,nameOnTheDisk);
			
			//insertion du livre dans la base de données

				try{
					bookRepository.save(book);
					return new ResponseEntity(new SuccessClass("livre enregistré avec succès"),HttpStatus.OK);
					
				}catch(Exception e){
					logger.error("le livre a été enregistré sur le disque mais son nom n'a pas"
							+ "été enregistré dans la base de données");
					return new ResponseEntity(new ErrorClass("le livre a été enregistré sur "
							+ "le disque mais son nom n'a pas été enregistré dans la base de "
							+ "données"),HttpStatus.OK);
				}
						 
			
		}
			
		
		//methode pour l'ajout d'un livre en post
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/addBook",method=RequestMethod.POST)
		public ResponseEntity<?> addBookPost(HttpServletRequest request){
			
			
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
				logger.error("le fichier n'a pas pu etre sauvegadé sur le disque");
				return new ResponseEntity(new ErrorClass("le fichier n'a pas pu "
						+ "etre sauvegadé sur le disque"),HttpStatus.OK);
			}
			//creation du livre
			
			Book book = new Book(bookName,bookAuthor,bookEdition,bookPrice,nameOnTheDisk);
			
			//insertion du livre dans la base de données

				try{
					bookRepository.save(book);
					return new ResponseEntity(new SuccessClass("livre enregistré avec succès"),HttpStatus.OK);
					
				}catch(Exception e){
					logger.error("le livre a été enregistré sur le disque mais son nom n'a pas"
							+ "été enregistré dans la base de données");
					return new ResponseEntity(new ErrorClass("le livre a été enregistré sur "
							+ "le disque mais son nom n'a pas été enregistré dans la base de "
							+ "données"),HttpStatus.OK);
				}
						 
			
		}
	
		
//***************************************************************************************************************		
		//******************************************************************************//
		//***********************methode pour la recherche des livre par le nom du livre*******************//
		//******************************************************************************//		

			//methode pour la recherche des livre en get
			

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/researchBookByName",method=RequestMethod.GET)
			public ResponseEntity<?> researchBookByNameGet(HttpServletRequest request){
				//recuperation des parametres de la requete
				
				String bookName =request.getParameter("bookName");
				//creation du livre
				
				Book book = new Book();
				
				//insertion du livre dans la base de données
					
						book = bookRepository.findByBookName(bookName);
						
						
					if(book==null){
						logger.error("le livre de nom "+bookName+" n'existe pas!");
						return new ResponseEntity(new ErrorClass("le livre de nom "
						+bookName+" n'existe pas!"),HttpStatus.OK);
					}else{
						return new ResponseEntity(new SuccessClass("recherche effectuée!", book),HttpStatus.OK);
					}
					
			}
			//methode pour la recherche des livre en post
		

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/researchBookByName",method=RequestMethod.POST)
			public ResponseEntity<?> researchBookByNamePost(HttpServletRequest request){
				//recuperation des parametres de la requete
				
				String bookName =request.getParameter("bookName");
				//creation du livre
				
				Book book = new Book();
				
				//insertion du livre dans la base de données
					
						book = bookRepository.findByBookName(bookName);
						
						
					if(book==null){
						logger.error("le livre de nom "+bookName+" n'existe pas!");
						return new ResponseEntity(new ErrorClass("le livre de nom "
						+bookName+" n'existe pas!"),HttpStatus.OK);
					}else{
						return new ResponseEntity(new SuccessClass("recherche effectuée!", book),HttpStatus.OK);
					}
					
			}
//***************************************************************************************************************
			//******************************************************************************//
			//***********************methode pour la recherche de tous les livres**********//
			//******************************************************************************//		
			
			//methode pour la recherche de tous les livres en get
			

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/researchAllBook",method=RequestMethod.GET)
			public ResponseEntity<List<Book>> researchAllBookGet(HttpServletRequest request){
				

				//creation de laliste des livres
				
				List<Book> listOfBook = new ArrayList<Book>();
				
				//recuperation des livres dans la base de données
					
				listOfBook = bookRepository.findAll();	
				if(listOfBook.isEmpty()){
					logger.error("aucun livre n'est enregistré dans la base de données");
					return new ResponseEntity(new ErrorClass("aucun livre n'est enregistré "
							+ "dans la base de données"),HttpStatus.OK);
				}else{
					return new ResponseEntity<List<Book>>(listOfBook,HttpStatus.OK);
				}
				
	
		}
			
			//methode pour la recherche de tous les livres en post
			

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/researchAllBook",method=RequestMethod.POST)
			public ResponseEntity<List<Book>> researchAllBookPost(HttpServletRequest request){
				

				//creation de laliste des livres
				
				List<Book> listOfBook = new ArrayList<Book>();
				
				//recuperation des livres dans la base de données
					
				listOfBook = bookRepository.findAll();	
				if(listOfBook.isEmpty()){
					logger.error("aucun livre n'est enregistré dans la base de données");
					return new ResponseEntity(new ErrorClass("aucun livre n'est enregistré "
							+ "dans la base de données"),HttpStatus.OK);
				}else{
					return new ResponseEntity<List<Book>>(listOfBook,HttpStatus.OK);
				}
				
	
		}
			
//***************************************************************************************************************
			
			//******************************************************************************//
			//***********************methode pour la recherche des livres par auteur**********//
			//******************************************************************************//		
			
			//methode pour la recherche des livre par auteur en get
			

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/researchBookByAuthor",method=RequestMethod.GET)
			public ResponseEntity<?> researchBookByAuthorGet(HttpServletRequest request){

				//recuperation des parametres de la requete
				
				String bookAuthor =request.getParameter("bookAuthor");
				//creation de la liste des livres
				
				List<Book> listOfBook = new ArrayList<Book>();
				
				//recuperation des livres dans la base de données
					
				listOfBook = bookRepository.findByBookAuthor(bookAuthor);
						
				if(listOfBook.isEmpty()){
					logger.error("l'auteur "+bookAuthor+" n'a aucun livre"
							+ " n'est enregistré dans la base de données");
					return new ResponseEntity(new ErrorClass("l'auteur "+bookAuthor+" n'a aucun livre"
							+ " n'est enregistré dans la base de données"),HttpStatus.OK);
				}else{
					return new ResponseEntity<List<Book>>(listOfBook,HttpStatus.OK);
				}
				
	
		}
		
			
			//methode pour la recherche des livre par auteur en post
			

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/researchBookByAuthor",method=RequestMethod.POST)
			public ResponseEntity<?> researchBookByAuthorPost(HttpServletRequest request){
				//recuperation des parametres de la requete
				
				String bookAuthor =request.getParameter("bookAuthor");
				//creation de la liste des livres
				
				List<Book> listOfBook = new ArrayList<Book>();
				
				//recuperation des livres dans la base de données
					
				listOfBook = bookRepository.findByBookAuthor(bookAuthor);
						
				if(listOfBook.isEmpty()){
					logger.error("l'auteur "+bookAuthor+" n'a aucun livre"
							+ " n'est enregistré dans la base de données");
					return new ResponseEntity(new ErrorClass("l'auteur "+bookAuthor+" n'a aucun livre"
							+ " n'est enregistré dans la base de données"),HttpStatus.OK);
				}else{
					return new ResponseEntity<List<Book>>(listOfBook,HttpStatus.OK);
				}
				
	
		}
//***************************************************************************************************************
			
			//******************************************************************************//
			//***********************methode pour la suppression d'un livre**********//
			//******************************************************************************//		

			
			//methode pour la suppression d'un livre en get
			

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/deleteBook",method=RequestMethod.GET)
			public ResponseEntity<?> deleteBookGet(HttpServletRequest request){
	
				//recuperation des parametres de la requete
				
				String bookName =request.getParameter("bookName");
				//creation du livre a supprimer
				
				Book book = new Book();
				
				//recuperation du livre dans la base de données
					
				book = bookRepository.findByBookName(bookName);
						
						
				if(book==null){
					logger.error("le livre de nom "+bookName+" n'existe pas!");
					return new ResponseEntity(new ErrorClass("le livre de nom "
					+bookName+" n'existe pas!"),HttpStatus.OK);
				}else{
					bookRepository.deleteByBookId(book.getBookId());
					return new ResponseEntity(new SuccessClass("suppression "
							+ "effectuée avec succes"),HttpStatus.OK);
				}
					 
			
		}
		
			//methode pour la suppression des livre en post
			

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/deleteBook",method=RequestMethod.POST)
			public ResponseEntity<?> deleteBookPost(HttpServletRequest request){
				
				
				//recuperation des parametres de la requete
				
				String bookName =request.getParameter("bookName");
				//creation du livre a supprimer
				
				Book book = new Book();
				
				//recuperation du livre dans la base de données
					
				book = bookRepository.findByBookName(bookName);
						
						
				if(book==null){
					logger.error("le livre de nom "+bookName+" n'existe pas!");
					return new ResponseEntity(new ErrorClass("le livre de nom "
					+bookName+" n'existe pas!"),HttpStatus.OK);
				}else{
					bookRepository.deleteByBookId(book.getBookId());
					return new ResponseEntity(new SuccessClass("suppression "
							+ "effectuée avec succes"),HttpStatus.OK);
				}
					 
			
		}
//***************************************************************************************************************
			//******************************************************************************//
			//***********************methode pour la mise a jour des livres**********//
			//******************************************************************************//		

			//methode pour la mise a jour des livres en get
			

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/updateBook",method=RequestMethod.GET)
			public ResponseEntity<?> updateBookGet(HttpServletRequest request){

				//recuperation des parametres de la requete
				String bookName = request.getParameter("bookName"); 
				double newBookPrice = Double.parseDouble(request.getParameter("newBookPrice"));
				
				//creation du livre a supprimer
				
				Book book = new Book();
				
				//recuperation du livre dans la base de données
					
					book = bookRepository.findByBookName(bookName);
						
						
					if(book==null){
						logger.error("le livre de nom "+bookName+" n'existe pas!");
						return new ResponseEntity(new ErrorClass("le livre de nom "
						+bookName+" n'existe pas!"), HttpStatus.OK);
					}else{
						book.setBookPrice(newBookPrice);
						try{
						bookRepository.save(book);
						return new ResponseEntity(new SuccessClass("mise à jour"
								+ " effectuée avec succes"),HttpStatus.OK);
						}catch(Exception e){
							logger.error("echec de la mise à jour, le serveur est arreté");
							return new ResponseEntity(new ErrorClass("echec de la mise à"
									+ " jour, le serveur est arreté"),HttpStatus.OK);
						}
						
					}	
			}
			
			//methode pour la mise a jour des livres en post
			

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/updateBook",method=RequestMethod.POST)
			public ResponseEntity<?> updateBookPost(HttpServletRequest request){
				

				//recuperation des parametres de la requete
				String bookName = request.getParameter("bookName"); 
				double newBookPrice = Double.parseDouble(request.getParameter("newBookPrice"));
				
				//creation du livre a supprimer
				
				Book book = new Book();
				
				//recuperation du livre dans la base de données
					
					book = bookRepository.findByBookName(bookName);
						
						
					if(book==null){
						logger.error("le livre de nom "+bookName+" n'existe pas!");
						return new ResponseEntity(new ErrorClass("le livre de nom "
						+bookName+" n'existe pas!"), HttpStatus.OK);
					}else{
						book.setBookPrice(newBookPrice);
						try{
						bookRepository.save(book);
						return new ResponseEntity(new SuccessClass("mise à jour"
								+ " effectuée avec succes"),HttpStatus.OK);
						}catch(Exception e){
							logger.error("echec de la mise à jour, le serveur est arreté");
							return new ResponseEntity(new ErrorClass("echec de la mise à"
									+ " jour, le serveur est arreté"),HttpStatus.OK);
						}
						
					}	
			}
			
//***************************************************************************************************************	
			//******************************************************************************//
			//***********************methode de deconnexion******************************//
			//******************************************************************************//
			
			//methode pour la gestion de la deconnexion de l'administrateur en get
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/deconnection", method=RequestMethod.GET)
			public ResponseEntity<?> deconnectionGet(HttpServletRequest request){
				

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
					return new ResponseEntity(new SuccessClass("deconnexion reussie!"),HttpStatus.OK);
				}catch(Exception e){
					logger.error("la session n'a pas pu etre fermé!");
					return new ResponseEntity(new ErrorClass("la "
							+ "session n'a pas pu etre fermé"),HttpStatus.OK);
				}
				}else{
					logger.error("aucune session n'est ouverte");
					return new ResponseEntity(new ErrorClass("aucune session n'est ouverte"),HttpStatus.OK);
				}
		
			}
	
			
			
			//methode pour la gestion de la connexion de l'administrateur en post
			
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/deconnection", method=RequestMethod.POST)
		public ResponseEntity<?> deconnectionPost(HttpServletRequest request){
			
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
				return new ResponseEntity(new SuccessClass("deconnexion reussie!"),HttpStatus.OK);
			}catch(Exception e){
				logger.error("la session n'a pas pu etre fermé!");
				return new ResponseEntity(new ErrorClass("la "
						+ "session n'a pas pu etre fermé"),HttpStatus.OK);
			}
			}else{
				logger.error("aucune session n'est ouverte");
				return new ResponseEntity(new ErrorClass("aucune session n'est ouverte"),HttpStatus.OK);
			}
	
		}
				
				
//***********************************************************************************************************	
				//******************************************************************************//
				//***********************methode creation d'un nouveau programme****************//
				//******************************************************************************//


		//methode pour la creation d'un nouvel article en get
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/addSchoolCalender", method=RequestMethod.GET)
		public ResponseEntity<?> addSchoolCalenderGet(HttpServletRequest request){
			
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
				logger.error("le fichier n'a pas pu"
						+ " etre sauvegadé sur le disque");
				return new ResponseEntity(new ErrorClass("le fichier n'a pas pu"
						+ " etre sauvegadé sur le disque"),HttpStatus.OK);

			}
			//creation du programme
			
			SchoolCalender schoolCalender = new SchoolCalender(schoolCalenderName,
																schoolCalenderType,
																schoolCalenderYear,
																nameOnTheDisk);
			
			//insertion du livre dans la base de données
			
			try{
				 schoolCalenderRepository.save(schoolCalender);
				return new ResponseEntity(new SuccessClass("programme enregistré avec succès"),HttpStatus.OK);
				
			}catch(Exception e){
				logger.error("le programme a été enregistré sur le disque mais son nom n'a pas"
						+ "été enregistré dans la base de données");
				return new ResponseEntity(new ErrorClass("le programme a été"
						+ " enregistré sur le disque mais son nom n'a pas"
						+ "été enregistré dans la base de données"),HttpStatus.OK);
			}
	
		}

		//methode pour la creation d'un nouvel article en post
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/addSchoolCalender", method=RequestMethod.POST)
		public ResponseEntity<?> createSchoolCalenderPost(HttpServletRequest request){
			
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
				logger.error("le fichier n'a pas pu"
						+ " etre sauvegadé sur le disque");
				return new ResponseEntity(new ErrorClass("le fichier n'a pas pu"
						+ " etre sauvegadé sur le disque"),HttpStatus.OK);

			}
			//creation du programme
			
			SchoolCalender schoolCalender = new SchoolCalender(schoolCalenderName,
																schoolCalenderType,
																schoolCalenderYear,
																nameOnTheDisk);
			
			//insertion du livre dans la base de données
			
			try{
				 schoolCalenderRepository.save(schoolCalender);
				return new ResponseEntity(new SuccessClass("programme enregistré avec succès"),HttpStatus.OK);
				
			}catch(Exception e){
				logger.error("le programme a été enregistré sur le disque mais son nom n'a pas"
						+ "été enregistré dans la base de données");
				return new ResponseEntity(new ErrorClass("le programme a été"
						+ " enregistré sur le disque mais son nom n'a pas"
						+ "été enregistré dans la base de données"),HttpStatus.OK);
			}
	
		}

//***************************************************************************************************************
	//******************************************************************************//
	//***********************methode pour la suppression d'un programme**********//
	//******************************************************************************//		

	
		//methode pour la suppression d'un programme en get
		
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/deleteSchoolCalender",method=RequestMethod.GET)
		public ResponseEntity<?> deleteSchoolCalenderGet(HttpServletRequest request){
	
			//recuperation des parametres de la requete
			
			String schoolCalenderName =request.getParameter("schoolCalenderName");
			//creation du programme à supprimer
			
			SchoolCalender schoolCalender = new SchoolCalender();
			
			//recuperation de l'article dans la base de données
				
			schoolCalender = schoolCalenderRepository.findBySchoolCalenderName(schoolCalenderName);
				
				
			if(schoolCalender==null){
				logger.error("notFoundError", "le programme de nom "+schoolCalenderName+" n'existe pas!");
				return new ResponseEntity(new ErrorClass("le programme de nom "
				+schoolCalenderName+" n'existe pas!"),HttpStatus.OK);
			}else{
				schoolCalenderRepository.deleteByschoolCalenderId(schoolCalender.getSchoolCalenderId());
				return new ResponseEntity(new SuccessClass("suppression effectuée avec succes"),HttpStatus.OK);
			}
			
		 
		
		}
	
	//methode pour la suppression d'un programme en post
	

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/deleteSchoolCalender",method=RequestMethod.POST)
		public ResponseEntity<?> deleteSchoolCalenderPost(HttpServletRequest request){
			
			
			//recuperation des parametres de la requete
			
			String schoolCalenderName =request.getParameter("schoolCalenderName");
			//creation du programme à supprimer
			
			SchoolCalender schoolCalender = new SchoolCalender();
			
			//recuperation de l'article dans la base de données
				
			schoolCalender = schoolCalenderRepository.findBySchoolCalenderName(schoolCalenderName);
				
				
			if(schoolCalender==null){
				logger.error("notFoundError", "le programme de nom "+schoolCalenderName+" n'existe pas!");
				return new ResponseEntity(new ErrorClass("le programme de nom "
				+schoolCalenderName+" n'existe pas!"),HttpStatus.OK);
			}else{
				schoolCalenderRepository.deleteByschoolCalenderId(schoolCalender.getSchoolCalenderId());
				return new ResponseEntity(new SuccessClass("suppression effectuée avec succes"),HttpStatus.OK);
			}
			
		}
		
//***************************************************************************************************************
		
		//******************************************************************************//
		//*************methode pour la recherche des programmes suivant l'année**********//
		//******************************************************************************//		
		
		//methode pour la recherche d'un programme en get
		
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/researchSchoolCalenderByYear",method=RequestMethod.GET)
		public ResponseEntity<List<SchoolCalender>> researchSchoolCalenderByYearGet(HttpServletRequest request){
			
	
			//recuperation des parametres de la requete
			
			String schoolCalenderYear =request.getParameter("schoolCalenderyear");
			//creation de l'article à renvoyer
			
			List<SchoolCalender> listOfSchoolCalender = new ArrayList<SchoolCalender>();
			
			//recuperation de l'article dans la base de données
				
			listOfSchoolCalender = schoolCalenderRepository.findBySchoolCalenderYear(schoolCalenderYear);
				
			if(listOfSchoolCalender.isEmpty()){
				logger.error("aucun programme pour le compte de l'année "
			+schoolCalenderYear+" n'est enrégisté!");
				return new ResponseEntity(new ErrorClass("aucun programme pour le compte de l'année "
						+schoolCalenderYear+" n'est enrégisté!"),HttpStatus.OK);
			}else{
				return new ResponseEntity<List<SchoolCalender>>(listOfSchoolCalender,HttpStatus.OK);
			}
			
		}
	

		//methode pour la recherche d'un programme en get
		
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/researchSchoolCalenderByYear",method=RequestMethod.POST)
		public ResponseEntity<?> researchSchoolCalenderByYearPost(HttpServletRequest request){
			
			//recuperation des parametres de la requete
			
			String schoolCalenderYear =request.getParameter("schoolCalenderyear");
			//creation de l'article à renvoyer
			
			List<SchoolCalender> listOfSchoolCalender = new ArrayList<SchoolCalender>();
			
			//recuperation de l'article dans la base de données
				
			listOfSchoolCalender = schoolCalenderRepository.findBySchoolCalenderYear(schoolCalenderYear);
				
			if(listOfSchoolCalender.isEmpty()){
				logger.error("aucun programme pour le compte de l'année "
			+schoolCalenderYear+" n'est enrégisté!");
				return new ResponseEntity(new ErrorClass("aucun programme pour le compte de l'année "
						+schoolCalenderYear+" n'est enrégisté!"),HttpStatus.OK);
			}else{
				return new ResponseEntity<List<SchoolCalender>>(listOfSchoolCalender,HttpStatus.OK);
			}
			
		}
	

	
	
//************************************************************************************************************	
	//******************************************************************************//
	//***********************methode creation d'une nouvelle bourse*******************//
		//******************************************************************************//
		
		
		//methode pour la creation d'une nouvelle bourse en get
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/addScolarship", method=RequestMethod.GET)
		public ResponseEntity<?> addScolarshipGet(HttpServletRequest request){
		

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
				return new ResponseEntity(new SuccessClass("bourse enregistrée avec succès"),HttpStatus.OK);
				
			}catch(Exception e){
				logger.error("echec de l'enregistrement de la bourse");
				return new ResponseEntity(new ErrorClass("echec de "
						+ "l'enregistrement de la bourse"),HttpStatus.OK);
			}
	
		}




		//methode pour la creation d'une nouvelle bourse en post

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/addScolarship", method=RequestMethod.POST)
		public ResponseEntity<?> addScolarshipPost(HttpServletRequest request){
			
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
					return new ResponseEntity(new SuccessClass("bourse enregistrée avec succès"),HttpStatus.OK);
					
				}catch(Exception e){
					logger.error("echec de l'enregistrement de la bourse");
					return new ResponseEntity(new ErrorClass("echec de "
							+ "l'enregistrement de la bourse"),HttpStatus.OK);
				}
		
			}

	
//************************************************************************************************************
		//******************************************************************************//
		//***********************methode pour la suppression d'une bourse**********//
		//******************************************************************************//		
		
		
		//methode pour la suppression d'une bourse en get
		
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/deleteScholarship",method=RequestMethod.GET)
		public ResponseEntity<?> deleteScholarshipGet(HttpServletRequest request){

			//recuperation des parametres de la requete
			
			String scholarshipName =request.getParameter("scholarshipName");
			//creation du programme à supprimer
			
			Scholarship scholarship = new Scholarship();
			
			//recuperation de la bourse dans la base de données
			
			scholarship = scholarshipRepository.findByScholarshipName(scholarshipName);
				
				
			if(scholarship==null){
				logger.error("la bourse de nom "+scholarshipName+" n'existe pas!");
				return new ResponseEntity(new ErrorClass("la bourse de nom "
				+scholarshipName+" n'existe pas!"), HttpStatus.OK);
			}else{
				schoolCalenderRepository.deleteByschoolCalenderId(scholarship.getScholarshipId());
				return new ResponseEntity(new SuccessClass("suppression "
						+ "effectuée avec succes"),HttpStatus.OK);
			}
			
			 
		}
		
		//methode pour la suppression d'une bourse en post
		
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/deleteScholarship",method=RequestMethod.POST)
		public ResponseEntity<?> deleteScholarshipPost(HttpServletRequest request){
		
			//recuperation des parametres de la requete
			
			String scholarshipName =request.getParameter("scholarshipName");
			//creation du programme à supprimer
			
			Scholarship scholarship = new Scholarship();
			
			//recuperation de la bourse dans la base de données
			
			scholarship = scholarshipRepository.findByScholarshipName(scholarshipName);
				
				
			if(scholarship==null){
				logger.error("la bourse de nom "+scholarshipName+" n'existe pas!");
				return new ResponseEntity(new ErrorClass("la bourse de nom "
				+scholarshipName+" n'existe pas!"), HttpStatus.OK);
			}else{
				schoolCalenderRepository.deleteByschoolCalenderId(scholarship.getScholarshipId());
				return new ResponseEntity(new SuccessClass("suppression "
						+ "effectuée avec succes"),HttpStatus.OK);
			}
			
			 
		}
		
		
//***********************************************************************************************************

		//******************************************************************************//
		//*************methode pour la recherche des bourses suivant le type**********//
		//******************************************************************************//		
		
		//methode pour la recherche des bourses en get
		
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/researchScholarshipByType",method=RequestMethod.GET)
		public ResponseEntity<List<Scholarship>> researchScholarshipByTypeGet(HttpServletRequest request){
			
			//recuperation des parametres de la requete
			
			String scholarshipType =request.getParameter("scholarshipType");
			//creation de la liste des bourses trouvées
			
			List<Scholarship> listOfScholarship = new ArrayList<Scholarship>();
			
			//recuperation de l'article dans la base de données
			
			listOfScholarship = scholarshipRepository.findByScholarshipType(scholarshipType);
					
			if(listOfScholarship.isEmpty()){
				logger.error("aucune bourse "+scholarshipType+" n'est enrégisté!");
				return new ResponseEntity(new ErrorClass("aucune bourse "
				+scholarshipType+" n'est enrégisté!"),HttpStatus.OK);
			}else{
				return new ResponseEntity<List<Scholarship>>(listOfScholarship,HttpStatus.OK);
			}

		}


		//methode pour la recherche des bourses en get
		
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/researchScholarshipByType",method=RequestMethod.POST)
		public ResponseEntity<List<Scholarship>> researchScholarshipByTypePost(HttpServletRequest request){
			//recuperation des parametres de la requete
			
			String scholarshipType =request.getParameter("scholarshipType");
			//creation de la liste des bourses trouvées
			
			List<Scholarship> listOfScholarship = new ArrayList<Scholarship>();
			
			//recuperation de l'article dans la base de données
			
			listOfScholarship = scholarshipRepository.findByScholarshipType(scholarshipType);
					
			if(listOfScholarship.isEmpty()){
				logger.error("aucune bourse "+scholarshipType+" n'est enrégisté!");
				return new ResponseEntity(new ErrorClass("aucune bourse "
				+scholarshipType+" n'est enrégisté!"),HttpStatus.OK);
			}else{
				return new ResponseEntity<List<Scholarship>>(listOfScholarship,HttpStatus.OK);
			}

		}
		
		//**********************************************************************************************************

		//******************************************************************************//
		//*************methode pour la sauvegarde des newsletters***************************//
		//******************************************************************************//		


		//methode pour la sauvegarde des newsletters en get
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/addNewsletter",method=RequestMethod.GET)
		public ResponseEntity<?> addNewsletterGet(HttpServletRequest request){
			//recuperation des parametres de la requete
			
			String newsletterId =request.getParameter("newsletterId");
			String publication = request.getParameter("publication");
			String actuality = request.getParameter("actuality");
		
			Newsletter newsletter;
			
			newsletter = newsletterRepository.findByNewsletterId(newsletterId);
			if(newsletter != null){
				if(actuality!=null)
					newsletter.getListOfPrincipalActuality().add(actuality);
				if(publication!=null)
					newsletter.getListOfPublication().add(publication);
			}else{
				newsletter = new Newsletter(newsletterId);
				if(actuality!=null){
					if(!(newsletter.getListOfPrincipalActuality().contains(actuality))){
						newsletter.getListOfPrincipalActuality().add(actuality);
					}else{
						return new ResponseEntity(new ErrorClass("echec de l'enregistrement"
								+ " de l'actualité elle est deja presente dans la liste des actualités!!"),HttpStatus.OK);
					}
				}
				if(publication!=null){
					if(!(newsletter.getListOfPublication().contains(publication))){
						newsletter.getListOfPublication().add(publication);
					}else{
						return new ResponseEntity(new ErrorClass("echec de l'enregistrement"
						+ " de la publication elle est deja presente dans la liste des actualités!!"),HttpStatus.OK);
					}
				}	
			}
			try {
				newsletterRepository.save(newsletter);
				return new ResponseEntity(new SuccessClass("newsletter enregistrée avec succès!!"),HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity(new ErrorClass("echec de l'enregistrement"
						+ " de la newsletter!!"),HttpStatus.OK);
			}
		
		
		}

		//methode pour la sauvegarde des newsletters en get
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/addNewsletter",method=RequestMethod.POST)
		public ResponseEntity<?> addNewsletterPost(HttpServletRequest request){
			//recuperation des parametres de la requete
			
			String newsletterId =request.getParameter("newsletterId");
			String publication = request.getParameter("publication");
			String actuality = request.getParameter("actuality");
		
			Newsletter newsletter;
			
			newsletter = newsletterRepository.findByNewsletterId(newsletterId);
			if(newsletter != null){
				if(actuality!=null)
					newsletter.getListOfPrincipalActuality().add(actuality);
				if(publication!=null)
					newsletter.getListOfPublication().add(publication);
			}else{
				newsletter = new Newsletter(newsletterId);
				if(actuality!=null)
					newsletter.getListOfPrincipalActuality().add(actuality);
				if(publication!=null)
					newsletter.getListOfPublication().add(publication);

			}
			try {
				newsletterRepository.save(newsletter);
				return new ResponseEntity(new SuccessClass("newsletter enregistrée avec succès!!"),HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity(new ErrorClass("echec de l'enregistrement"
						+ " de la newsletter!!"),HttpStatus.OK);
			}
		
		
		}

		
		
//**********************************************************************************************************

				//******************************************************************************//
				//*************methode pour l'envoie des newsletters***************************//
				//******************************************************************************//		

		

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/sendNewsletter",method=RequestMethod.GET)
		public ResponseEntity<?> sendNewsletterGet(HttpServletRequest request){
			//recuperation des parametres de la requete
			
			String newsletterId =request.getParameter("newsletterId");

			Newsletter newsletter = new Newsletter();
			
			newsletter = newsletterRepository.findByNewsletterId(newsletterId);
			mailSender = new MailSender();		

			List<NewsletterConcern> listOfNewsletterConcern = new ArrayList<NewsletterConcern>();
				listOfNewsletterConcern = newsletterConcernRepository.findAll();
			if (!listOfNewsletterConcern.isEmpty()){
			try {
				for(NewsletterConcern nc:listOfNewsletterConcern){
					/*mailSender.sendEmailWithFreemarker(nc.getNewsletterConcernEmail(),newsletterSubject,
						 newsletter.getListOfPrincipalActuality(),
						 newsletter.getListOfPublication(), "newsletterTemplate.jsp");*/
					//*
					 mailSender.sendSimpleEmail(nc.getNewsletterConcernEmail(), "l'envoie marche quand meme",
							"newsletter du site d'orientation de l'entreprise bocobi2");
					 //*/
				}
				return new ResponseEntity(new SuccessClass("newsletter envoyée avec succès!!"),HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(new ErrorClass("echec de l'envoie"
						+ " de la newsletter aux differents inscrits!!"),HttpStatus.OK);
			}

			}else{
				return new ResponseEntity(new ErrorClass("yaaaaaaaaaaaaa la liste que"
						+ " tu as recuperee est d'abord vide!"),HttpStatus.OK);
			}
		}
	


//************************************************************************************************************

		

	//methodes utiles
		

	 

}
