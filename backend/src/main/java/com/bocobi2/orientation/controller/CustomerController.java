package com.bocobi2.orientation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.bocobi2.orientation.model.Client;
import com.bocobi2.orientation.model.Testimony;
import com.bocobi2.orientation.repositories.*;

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
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET, params = { "firstNameCustomer",
			"lastNameCustomer", "phoneNumber", "emailAddress", "password" })
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
		
		logger.info("enregistrement du client {}",client);;

			clientRepository.save(client);
		
		

		
		return new ResponseEntity<Client>(client,HttpStatus.CREATED);
	}

	// methode d'ajout d'un nouveau client en post
	@SuppressWarnings("unchecked")
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
		
		logger.info("enregistrement du client {}",client);;

			clientRepository.save(client);
		
		

		
		return new ResponseEntity<Client>(client,HttpStatus.CREATED);
	}
	//***************************************************************************************************************	
			//******************************************************************************//
			//***********************methode de connexion******************************//
			//******************************************************************************//
		
	//methode d'authentification en get
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/authentication", method = RequestMethod.GET, params = { "login", "password" })
	private JSONObject authenticationGet(HttpServletRequest request) {
		JSONObject result, success, errors;
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();

		HttpSession session;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Client client = new Client();

		
			client = clientRepository.findByEmailAddress(login);
		if(client==null)
			errors.put("notFoundError", "l'utilisateur d'adresse email " + login + "est introuvable");
		

		if (errors.isEmpty()) {
			try {
				validatePasswordAndLogin(password, login);
				session = request.getSession();
				session.setAttribute("customerInSession", client);
				success.put("customerInSession", client);
				success.put("rapport", "session ouverte avec succes");
			} catch (Exception e) {
				errors.put("errorMessage", e.getMessage());
			}
		}
		result.put("success", success);
		result.put("errors", errors);
		return result;
	}

	//methode d'authentification en post
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/authentication", method = RequestMethod.POST, params = { "login", "password" })
	private JSONObject authenticationPost(HttpServletRequest request) {
		JSONObject result, success, errors;
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();

		HttpSession session;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Client client = new Client();

		try {
			client = clientRepository.findByEmailAddress(login);
		} catch (Exception e) {
			errors.put("notFoundError", "l'utilisateur d'adresse email " + login + "est introuvable");
		}

		if (errors.isEmpty()) { 
			try {
				validatePasswordAndLogin(password, login);
				session = request.getSession();
				session.setAttribute("customerInSession", client);
				success.put("customerInSession", client.toString());
				success.put("rapport", "session ouverte avec succes");
			} catch (Exception e) {
				errors.put("errorMessage", e.getMessage());
			}
		}
		result.put("success", success);
		result.put("errors", errors);
		return result;
	}
	
	
	
	//methode d'ajout d'un temoignage en get
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/postTestimony", method = RequestMethod.GET, params = { "testimonyContent" })
	private JSONObject postTestimonyGet(HttpServletRequest request) {
		JSONObject result, success, errors;
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();
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
			testimonyRepository.save(testimony);
			success.put("rapport", "temoignage enregistré avec succes");
		}catch(Exception e){
			errors.put("notSaveError", "le temoignage n'a pas été enregistré");
		}

		result.put("success", success);
		result.put("errors", errors);
		return result;
	}
	
	//methode d'ajout d'un temoignage en post
	
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/postTestimony", method = RequestMethod.POST, params = { "testimonyContent" })
		private JSONObject postTestimonyPost(HttpServletRequest request) {
			JSONObject result, success, errors;
			result = new JSONObject();
			success = new JSONObject();
			errors = new JSONObject();
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
				testimonyRepository.save(testimony);
				success.put("rapport", "temoignage enregistré avec succes");
			}catch(Exception e){
				errors.put("notSaveError", "le temoignage n'a pas été enregistré");
			}

			result.put("success", success);
			result.put("errors", errors);
			return result;
		}
		
//***************************************************************************************************************	
		//******************************************************************************//
		//***********************methode de deconnexion******************************//
		//******************************************************************************//
		
		//methode pour la gestion de la deconnexion du client en get
		
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
			
			//creation d'un objet clientistrateur
			
			Client client = new Client();
			
			//recheche dans la base de données de l'clientistrateur ayant les informations fournies

					session = request.getSession();
					client = (Client) session.getAttribute("customerInSession");
					
					if(client!=null){
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
		
		
		
		//methode pour la gestion de la connexion de l'clientistrateur en post
		
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
				
				//creation d'un objet clientistrateur
				
				Client client = new Client();;
				
				//recheche dans la base de données de l'clientistrateur ayant les informations fournies

						session = request.getSession();
						client = (Client) session.getAttribute("customerInSession");
						
						if(client!=null){
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

	
	// definition des methodes de controle des donnees recues de la vue

	private void validatePasswordAndLogin(String password, String login) throws Exception {
		// TODO Auto-generated method stub
		Client client = clientRepository.findByEmailAddress(login);
		if (!client.getPassword().equals(password)) {
			throw new Exception("le mot de passe entré ne corespond pas au login");
		}
	}

}
