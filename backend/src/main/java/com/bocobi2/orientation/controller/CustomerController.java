package com.bocobi2.orientation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bocobi2.orientation.model.Book;
import com.bocobi2.orientation.model.Client;
import com.bocobi2.orientation.model.ErrorClass;
import com.bocobi2.orientation.model.SuccessClass;
import com.bocobi2.orientation.model.Testimony;
import com.bocobi2.orientation.repositories.BookRepository;
import com.bocobi2.orientation.repositories.ClientRepository;
import com.bocobi2.orientation.repositories.TestimonyRepository;

@CrossOrigin(origins = "*")
@RequestMapping("/orientation/customer")
@RestController
public class CustomerController {

	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private TestimonyRepository testimonyRepository;

	@Autowired
	BookRepository bookRepository;

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}
	// ***************************************************************************************************************
	// ******************************************************************************//
	// ***********************methode de
	// connexion******************************//
	// ******************************************************************************//

	// methode d'authentification en get

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/authentication", method = RequestMethod.GET, params = { "login", "password" })
	private ResponseEntity<?> authenticationGet(HttpServletRequest request) {

		HttpSession session;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Client client = new Client();

		client = clientRepository.findByEmailAddress(login);
		if (client == null) {
			logger.error("l'utilisateur d'adresse email " + login + " est introuvable");
			return new ResponseEntity(
					new ErrorClass("l'utilisateur d'adresse email " + login + " est introuvable"),
					HttpStatus.OK);
		}

		try {
			validatePasswordAndLogin(password, login);
			session = request.getSession();
			session.setAttribute("customerInSession", client);
			logger.info("le client {} est actuelement en session", client);
			return new ResponseEntity(new SuccessClass("connection reussie!",client), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity(new SuccessClass(e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
		}

	}

	// methode d'authentification en post
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/authentication", method = RequestMethod.POST, params = { "login", "password" })
	private ResponseEntity<?> authenticationPost(HttpServletRequest request) {

		HttpSession session;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Client client = new Client();

		client = clientRepository.findByEmailAddress(login);
		if (client == null) {
			logger.error("l'utilisateur d'adresse email " + login + " est introuvable");
			return new ResponseEntity(
					new ErrorClass("l'utilisateur d'adresse email " + login + "" + " est introuvable"),
					HttpStatus.OK);
		}

		try {
			validatePasswordAndLogin(password, login);
			session = request.getSession();
			session.setAttribute("customerInSession", client);
			logger.info("le client {} est actuelement en session", client);
			return new ResponseEntity(new SuccessClass(client), HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity(new SuccessClass(e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	// ***************************************************************************************************************
		// ******************************************************************************//
		// ***********************methode de post d'un temoignage
		// par le client******************************//
		// ******************************************************************************//


	// methode d'ajout d'un temoignage en get

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/postTestimony", method = RequestMethod.GET, params = { "testimonyContent" })
	private ResponseEntity postTestimonyGet(HttpServletRequest request) {

		HttpSession session;

		session = request.getSession();
		Client client = (Client) session.getAttribute("customerInSession");

		// recupertion du temoignage

		String testimonyContent = request.getParameter("testimonyContent");
		String testimonyAuthor = client.getFirstNameCustomer() + " " + client.getLastNameCustomer();

		// cretion du temoignage

		Testimony testimony = new Testimony();
		testimony.setTestimonyAuthor(testimonyAuthor);
		testimony.setTestimonyContent(testimonyContent);

		try {
			logger.info("enregistrement du post");
			testimonyRepository.save(testimony);
			client.getCustomerListOfTestimonies().add(testimony);
			clientRepository.save(client);
			session.setAttribute("customerInSession", client);
			return new ResponseEntity(new SuccessClass("temoignage enregistré avec succes"), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("le temoignage n'a pas été enregistré");
			return new ResponseEntity(new ErrorClass("le temoignage n'a pas été enregistré"),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

	// methode d'ajout d'un temoignage en post

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/postTestimony", method = RequestMethod.POST, params = { "testimonyContent" })
	private ResponseEntity postTestimonyPost(HttpServletRequest request) {

		HttpSession session;

		session = request.getSession();
		Client client = (Client) session.getAttribute("customerInSession");

		// recupertion du temoignage

		String testimonyContent = request.getParameter("testimonyContent");
		String testimonyAuthor = client.getFirstNameCustomer() + " " + client.getLastNameCustomer();

		// cretion du temoignage

		Testimony testimony = new Testimony();
		testimony.setTestimonyAuthor(testimonyAuthor);
		testimony.setTestimonyContent(testimonyContent);

		try {
			logger.info("enregistrement du post");
			testimonyRepository.save(testimony);
			client.getCustomerListOfTestimonies().add(testimony);
			clientRepository.save(client);
			session.setAttribute("customerInSession", client);
			return new ResponseEntity(new SuccessClass("temoignage enregistré avec succes"), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("le temoignage n'a pas été enregistré");
			return new ResponseEntity(new ErrorClass("le temoignage n'a pas été enregistré"),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

	// ***************************************************************************************************************
	// ******************************************************************************//
	// ***********************methode de
	// deconnexion******************************//
	// ******************************************************************************//

	// methode pour la gestion de la deconnexion du client en get

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/deconnection", method = RequestMethod.GET)
	public ResponseEntity<?> deconnectionGet(HttpServletRequest request) {

		// objets utils

		HttpSession session;

		// creation d'un objet clientistrateur

		Client client = new Client();

		// recheche dans la base de données de l'clientistrateur ayant les
		// informations fournies

		session = request.getSession();
		client = (Client) session.getAttribute("customerInSession");

		if (client != null) {
			try {
				session.removeAttribute("customerInSession");
				session.invalidate();
				return new ResponseEntity(new SuccessClass("deconnexion reussie"), HttpStatus.OK);
			} catch (Exception e) {
				logger.error("la session n'a pas pu etre fermé");
				return new ResponseEntity(new ErrorClass("la session n'a pas pu etre fermé"),
						HttpStatus.OK);
			}
		} else {
			logger.error("aucune session n'est ouverte");
			return new ResponseEntity(new ErrorClass("aucune session n'est ouverte"), HttpStatus.OK);
		}

	}

	// methode pour la gestion de la connexion de l'clientistrateur en post

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/deconnection", method = RequestMethod.POST)
	public ResponseEntity<?> deconnectionPost(HttpServletRequest request) {

		// objets utils

		HttpSession session;

		// creation d'un objet clientistrateur

		Client client = new Client();

		// recheche dans la base de données de l'clientistrateur ayant les
		// informations fournies

		session = request.getSession();
		client = (Client) session.getAttribute("customerInSession");

		if (client != null) {
			try {
				session.removeAttribute("customerInSession");
				session.invalidate();
				return new ResponseEntity(new SuccessClass("deconnexion reussie"), HttpStatus.OK);
			} catch (Exception e) {
				logger.error("la session n'a pas pu etre fermé");
				return new ResponseEntity(new ErrorClass("la session n'a pas pu etre fermé"),
						HttpStatus.OK);
			}
		} else {
			logger.error("aucune session n'est ouverte");
			return new ResponseEntity(new ErrorClass("aucune session n'est ouverte"), HttpStatus.OK);
		}

	}

	// ***************************************************************************************************************

	// ******************************************************************************//
	// ***********************methode d'ajout d'un nouveau livre dans le
	// panier*****//
	// ****************************************************************************//

	// methode d'ajout d'un nouveau dans le panier en get
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/addInBasket", method = RequestMethod.GET)
	public ResponseEntity<?> addInBasketGet(HttpServletRequest request) {

		// recuperation du nom du livre

		String bookName = request.getParameter("bookName");
		HttpSession session = request.getSession();

		// instanciation du livre à ajouter

		Book book = new Book();
		book = bookRepository.findByBookName(bookName);
		Client client = (Client) session.getAttribute("customerInSession");

		// action a menner apres reception des informations

		logger.info("enregistrement du livre {} dans le panier du client {} ", book, client);
		if (book != null) {
			client.getCustomerBasket().add(book);
			clientRepository.save(client);
			session.setAttribute("customerInSession", client);
			return new ResponseEntity(new SuccessClass("client enregistré avec"
					+ "succès",client), HttpStatus.OK);

		} else {
			return new ResponseEntity(new ErrorClass("le livre de nom " + bookName + " n'existe pas"),
					HttpStatus.OK);
		}

	}

	// methode d'ajout d'un nouveau livre dans le panier en post

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/addInBasket", method = RequestMethod.POST)
	public ResponseEntity<?> addInBasketPost(HttpServletRequest request) {

		// recuperation du nom du livre

		String bookName = request.getParameter("bookName");
		HttpSession session = request.getSession();

		// instanciation du livre à ajouter

		Book book = new Book();
		book = bookRepository.findByBookName(bookName);
		Client client = (Client) session.getAttribute("customerInSession");

		// action a menner apres reception des informations

		logger.info("enregistrement du livre {} dans le panier du client {} ", book, client);
		if (book != null) {
			client.getCustomerBasket().add(book);
			clientRepository.save(client);
			session.setAttribute("customerInSession", client);
			return new ResponseEntity(new SuccessClass("client enregistré avec"
					+ "succès",client), HttpStatus.OK);

		} else {
			return new ResponseEntity(new ErrorClass("le livre de nom " + bookName + " n'existe pas"),
					HttpStatus.OK);
		}

	}
	// ***************************************************************************************************************

	// ******************************************************************************//
	// ***********************methode de suppression d'un livre du
	// panier d'un client*****//
	// ****************************************************************************//

	// methode de suppression d'un livre dans le panier en get
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/removeFromBasket", method = RequestMethod.GET)
	public ResponseEntity<?> removeFromBasketGet(HttpServletRequest request) {

		// recuperation du nom du livre

		String bookName = request.getParameter("bookName");
		HttpSession session = request.getSession();

		// instanciation du livre à supprimer

		Book book = new Book();
		book = bookRepository.findByBookName(bookName);
		Client client = (Client) session.getAttribute("customerInSession");
		// action a menner apres reception des informations

		logger.info("suppression du livre {} du panier du client {} ", book, client);
		
		if (!client.getCustomerBasket().isEmpty()) {
			if(client.getCustomerBasket().contains(book)){
			client.getCustomerBasket().remove(client.getCustomerBasket().indexOf(book));
			clientRepository.save(client);
			session.setAttribute("customerInSession", client);
			return new ResponseEntity(new SuccessClass("supression effectuée!",client), HttpStatus.OK);
			}else{
				return new ResponseEntity(new ErrorClass("le livre de nom"+bookName+" n'est pas present dans le "
						+ "panier de l'utilisateur en session "),
						HttpStatus.OK);
			}

		} else {
			return new ResponseEntity(new ErrorClass("desole votre panier est vide "),
					HttpStatus.OK);
		}

	}

	// methode de suppression d'un livre dans le panier en post
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/removeFromBasket", method = RequestMethod.POST)
	public ResponseEntity<?> removeFromBasketPost(HttpServletRequest request) {

		// recuperation du nom du livre

		String bookName = request.getParameter("bookName");
		HttpSession session = request.getSession();

		// instanciation du livre à supprimer

		Book book = new Book();
		book = bookRepository.findByBookName(bookName);
		Client client = (Client) session.getAttribute("customerInSession");
		// action a menner apres reception des informations

		logger.info("suppression du livre {} du panier du client {} ", book, client);
		
		if (!client.getCustomerBasket().isEmpty()) {
			if(client.getCustomerBasket().contains(book)){
			client.getCustomerBasket().remove(client.getCustomerBasket().indexOf(book));
			clientRepository.save(client);
			session.setAttribute("customerInSession", client);
			return new ResponseEntity<Client>(client, HttpStatus.OK);
			}else{
				return new ResponseEntity(new ErrorClass("le livre de nom"+bookName+" n'est pas present dans le "
						+ "panier de l'utilisateur en session "),
						HttpStatus.OK);
			}

		} else {
			return new ResponseEntity(new ErrorClass("desole votre panier est vide "),
					HttpStatus.OK);
		}

	}
	
// ***************************************************************************************************************

	// ******************************************************************************//
	// ***********************methode de recherche du
	// panier d'un client*****//
	// ****************************************************************************//

	// methode de recherche du panier en get
	@RequestMapping(value = "/findBasket", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> findBasketGet(HttpServletRequest request) {


		HttpSession session = request.getSession();

		Client client = clientRepository.findByEmailAddress(((Client) session.getAttribute("customerInSession")).getEmailAddress());
		// action a menner apres reception des informations

			return new ResponseEntity<List<Book>>(client.getCustomerBasket(),HttpStatus.OK);
		

	}

	// methode de recherche du panier en post
	@RequestMapping(value = "/findBasket", method = RequestMethod.POST)
	public ResponseEntity<List<Book>> findBasketPost(HttpServletRequest request) {

		// recuperation du nom du livre

		HttpSession session = request.getSession();

		// instanciation du livre à supprimer
		Client client = clientRepository.findByEmailAddress(((Client) session.getAttribute("customer"
				+ "InSession")).getEmailAddress());
		// action a menner apres reception des informations

			return new ResponseEntity<List<Book>>(client.getCustomerBasket(),HttpStatus.OK);
		

	}


	// definition des methodes de controle des donnees recues de la vue

	private void validatePasswordAndLogin(String password, String login) throws Exception {
		// TODO Auto-generated method stub
		Client client = clientRepository.findByEmailAddress(login);
		if (!client.getPassword().equals(password)) {
			throw new Exception("le mot de passe entré ne corespond pas au login");
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
	
}
