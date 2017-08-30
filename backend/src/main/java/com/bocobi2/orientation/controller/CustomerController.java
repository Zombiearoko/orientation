package com.bocobi2.orientation.controller;

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

import com.bocobi2.orientation.model.Client;
import com.bocobi2.orientation.model.ErrorClass;
import com.bocobi2.orientation.model.SuccessClass;
import com.bocobi2.orientation.model.Testimony;
import com.bocobi2.orientation.repositories.ClientRepository;
import com.bocobi2.orientation.repositories.TestimonyRepository;

@CrossOrigin(origins = "*")
@RequestMapping("/customer")
@RestController
public class CustomerController {
	
	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private TestimonyRepository testimonyRepository;


	public CustomerController() {
		// TODO Auto-generated constructor stub
	}
//***************************************************************************************************************	
			//******************************************************************************//
			//***********************methode d'ajout d'un nouveau client******************************//
			//******************************************************************************//
		
	// methode d'ajout d'un nouveau client en get
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public ResponseEntity<?> addClientGet(HttpServletRequest request) {

		// recuperation des informations du client

		String firstNameCustomer = (String) request.getParameter("firstNameCustomer");
		String lastNameCustomer = (String) request.getParameter("lastNameCustomer");
		String phoneNumber = (String) request.getParameter("phoneNumber");
		String emailAddress = (String) request.getParameter("emailAddress");
		String password = (String) request.getParameter("password");

		// instanciation du client à ajouter

		Client client = new Client();

		// action a menner apres reception des informations

		client.setFirstNameCustomer(firstNameCustomer);
		client.setLastNameCustomer(lastNameCustomer);
		client.setPhoneNumber(phoneNumber);
		client.setPassword(password);
		client.setEmailAddress(emailAddress);
		
		logger.info("enregistrement du client {}",client);
		if(clientRepository.findByEmailAddress(emailAddress)!=null){
			logger.error("le client {} est deja enregistré dans la base de donnees",client);
			return new ResponseEntity(new ErrorClass("le client est deja"
					+ " enregistré dans la base de donnees"),HttpStatus.CONFLICT);
		}
		clientRepository.save(client);
		return new ResponseEntity<Client>(client,HttpStatus.CREATED);
	}

	// methode d'ajout d'un nouveau client en post
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ResponseEntity<?> addClientPost(HttpServletRequest request) {

		// recuperation des informations du client

		String firstNameCustomer = (String) request.getParameter("firstNameCustomer");
		String lastNameCustomer = (String) request.getParameter("lastNameCustomer");
		String phoneNumber = (String) request.getParameter("phoneNumber");
		String emailAddress = (String) request.getParameter("emailAddress");
		String password = (String) request.getParameter("password");

		// instanciation du client à ajouter

		Client client = new Client();

		// action a menner apres reception des informations

		client.setFirstNameCustomer(firstNameCustomer);
		client.setLastNameCustomer(lastNameCustomer);
		client.setPhoneNumber(phoneNumber);
		client.setPassword(password);
		client.setEmailAddress(emailAddress);
		
		logger.info("enregistrement du client {}",client);
		if(clientRepository.findByEmailAddress(emailAddress)!=null){
			logger.error("le client {} est deja enregistré dans la base de donnees",client);
			return new ResponseEntity(new ErrorClass("le client est deja"
					+ " enregistré dans la base de donnees"),HttpStatus.CONFLICT);
		}
		clientRepository.save(client);
		return new ResponseEntity<Client>(client,HttpStatus.CREATED);
	}
//***************************************************************************************************************	
			//******************************************************************************//
			//***********************methode de connexion******************************//
			//******************************************************************************//
		
	//methode d'authentification en get
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/authentication", method = RequestMethod.GET, params = { "login", "password" })
	private ResponseEntity<?> authenticationGet(HttpServletRequest request) {

		HttpSession session;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Client client = new Client();

			client = clientRepository.findByEmailAddress(login);
		if(client==null){
			logger.error("l'utilisateur d'adresse email " + login + " est introuvable");
			return new ResponseEntity(new ErrorClass("l'utilisateur d'adresse email " + login + ""
					+ " est introuvable"),HttpStatus.NOT_FOUND);
			}
		
		try {
			validatePasswordAndLogin(password, login);
			session = request.getSession();
			session.setAttribute("customerInSession", client);
			logger.info("le client {} est actuelement en session", client);
			return new ResponseEntity(new SuccessClass(client),HttpStatus.OK );
		} catch (Exception e) {
			logger.error( e.getMessage());
			return new ResponseEntity(new SuccessClass(e.getMessage()),HttpStatus.NOT_ACCEPTABLE);
		}

	}

	//methode d'authentification en post
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/authentication", method = RequestMethod.POST, params = { "login", "password" })
	private ResponseEntity<?> authenticationPost(HttpServletRequest request) {

		HttpSession session;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Client client = new Client();

		
			client = clientRepository.findByEmailAddress(login);
		if(client==null){
			logger.error("l'utilisateur d'adresse email " + login + " est introuvable");
			return new ResponseEntity(new ErrorClass("l'utilisateur d'adresse email " + login + ""
					+ " est introuvable"),HttpStatus.NOT_FOUND);
			}
		
		try {
			validatePasswordAndLogin(password, login);
			session = request.getSession();
			session.setAttribute("customerInSession", client);
			logger.info("le client {} est actuelement en session", client);
			return new ResponseEntity(new SuccessClass(client),HttpStatus.OK );
		} catch (Exception e) {
			logger.error( e.getMessage());
			return new ResponseEntity(new SuccessClass(e.getMessage()),HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	
	//methode d'ajout d'un temoignage en get
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/postTestimony", method = RequestMethod.GET, params = { "testimonyContent" })
	private ResponseEntity postTestimonyGet(HttpServletRequest request) {
		
		HttpSession session;
		
		session = request.getSession();
		Client client = (Client) session.getAttribute("customerInSession");
		
		//recupertion du temoignage
		
		String testimonyContent = request.getParameter("testimonyContent");
		String testimonyAuthor = client.getFirstNameCustomer()+" "+client.getLastNameCustomer();
		
		//cretion du temoignage
		
		Testimony testimony = new Testimony();
		testimony.setTestimonyAuthor(testimonyAuthor);
		testimony.setTestimonyContent(testimonyContent);
		
		try{
			logger.info("enregistrement du post");
			testimonyRepository.save(testimony);
			client.postTestimony(testimony);
			clientRepository.save(client);
			return new ResponseEntity(new SuccessClass("temoignage enregistré avec succes"),HttpStatus.OK);
		}catch(Exception e){
			logger.error("le temoignage n'a pas été enregistré");
			return new ResponseEntity(new ErrorClass("le temoignage n'a pas été enregistré"),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	//methode d'ajout d'un temoignage en post
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value = "/postTestimony", method = RequestMethod.POST, params = { "testimonyContent" })
		private ResponseEntity postTestimonyPost(HttpServletRequest request) {
			
			HttpSession session;
			
			session = request.getSession();
			Client client = (Client) session.getAttribute("customerInSession");
			
			//recupertion du temoignage
			
			String testimonyContent = request.getParameter("testimonyContent");
			String testimonyAuthor = client.getFirstNameCustomer()+" "+client.getLastNameCustomer();
			
			//cretion du temoignage
			
			Testimony testimony = new Testimony();
			testimony.setTestimonyAuthor(testimonyAuthor);
			testimony.setTestimonyContent(testimonyContent);
			
			try{
				logger.info("enregistrement du post");
				testimonyRepository.save(testimony);
				client.postTestimony(testimony);
				clientRepository.save(client);
				return new ResponseEntity(new SuccessClass("temoignage enregistré avec succes"),HttpStatus.OK);
			}catch(Exception e){
				logger.error("le temoignage n'a pas été enregistré");
				return new ResponseEntity(new ErrorClass("le temoignage n'a pas été enregistré"),HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		
//***************************************************************************************************************	
		//******************************************************************************//
		//***********************methode de deconnexion******************************//
		//******************************************************************************//
		
		//methode pour la gestion de la deconnexion du client en get
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value="/deconnection", method=RequestMethod.GET)
		public ResponseEntity<?> deconnectionGet(HttpServletRequest request){

			//objets utils
			
			HttpSession session;
			
			//creation d'un objet clientistrateur
			
			Client client = new Client();
			
			//recheche dans la base de données de l'clientistrateur ayant les informations fournies

					session = request.getSession();
					client = (Client) session.getAttribute("customerInSession");
					
					if(client!=null){
					try{
						session.removeAttribute("customerInSession");
						session.invalidate();
						return new ResponseEntity(new SuccessClass("deconnexion reussie"),HttpStatus.OK);
					}catch(Exception e){
						logger.error("la session n'a pas pu etre fermé");
						return new ResponseEntity(new ErrorClass("la session"
								+ " n'a pas pu etre fermé"),HttpStatus.NOT_FOUND);
					}
					}else{
						logger.error("aucune session n'est ouverte");
						return new ResponseEntity(new ErrorClass("aucune "
								+ "session n'est ouverte"),HttpStatus.NOT_FOUND);
					}
			
		}
		
		
		
		//methode pour la gestion de la connexion de l'clientistrateur en post
		
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@RequestMapping(value="/deconnection", method=RequestMethod.POST)
			public ResponseEntity<?> deconnectionPost(HttpServletRequest request){

				//objets utils
				
				HttpSession session;
				
				//creation d'un objet clientistrateur
				
				Client client = new Client();
				
				//recheche dans la base de données de l'clientistrateur ayant les informations fournies

						session = request.getSession();
						client = (Client) session.getAttribute("customerInSession");
						
						if(client!=null){
						try{
							session.removeAttribute("customerInSession");
							session.invalidate();
							return new ResponseEntity(new SuccessClass("deconnexion reussie"),HttpStatus.OK);
						}catch(Exception e){
							logger.error("la session n'a pas pu etre fermé");
							return new ResponseEntity(new ErrorClass("la session"
									+ " n'a pas pu etre fermé"),HttpStatus.NOT_FOUND);
						}
						}else{
							logger.error("aucune session n'est ouverte");
							return new ResponseEntity(new ErrorClass("aucune "
									+ "session n'est ouverte"),HttpStatus.NOT_FOUND);
						}
				
			}

//***************************************************************************************************************	

	
	// definition des methodes de controle des donnees recues de la vue

	private void validatePasswordAndLogin(String password, String login) throws Exception {
		// TODO Auto-generated method stub
		Client client = clientRepository.findByEmailAddress(login);
		if (!client.getPassword().equals(password)) {
			throw new Exception("le mot de passe entré ne corespond pas au login");
		}
	}

}
