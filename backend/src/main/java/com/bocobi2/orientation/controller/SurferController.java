package com.bocobi2.orientation.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.bocobi2.orientation.model.NewsletterConcern;
import com.bocobi2.orientation.model.SuccessClass;
import com.bocobi2.orientation.repositories.AdministratorRepository;
import com.bocobi2.orientation.repositories.ArticleRepository;
import com.bocobi2.orientation.repositories.BookRepository;
import com.bocobi2.orientation.repositories.ClientRepository;
import com.bocobi2.orientation.repositories.NewsletterConcernRepository;
import com.bocobi2.orientation.repositories.NewsletterRepository;
import com.bocobi2.orientation.repositories.ScholarshipRepository;
import com.bocobi2.orientation.repositories.SchoolCalenderRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orientation/surfer")
public class SurferController {

	
	public static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);
	
	
	@Autowired
	private ClientRepository clientRepository;
	
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

	
// *************************************************************************************************************
	// ******************************************************************************//
	// ***********************methode d'ajout d'un nouveau
	// client******************************//
	// ******************************************************************************//

	// methode d'ajout d'un nouveau client en get
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public ResponseEntity<?> addClientGet(HttpServletRequest request) {

		// recuperation des informations du client

		String firstNameCustomer = (String) request.getParameter("firstNameCustomer");
		String lastNameCustomer = (String) request.getParameter("lastNameCustomer");
		String phoneNumber = (String) request.getParameter("phoneNumber");
		String emailAddress = (String) request.getParameter("emailAddress");
		String password = (String) request.getParameter("password");
		//clientRepository.deleteAll();
		// instanciation du client à ajouter

		Client client = new Client();

		// action a menner apres reception des informations

		client.setFirstNameCustomer(firstNameCustomer);
		client.setLastNameCustomer(lastNameCustomer);
		client.setPhoneNumber(phoneNumber);
		client.setPassword(password);
		client.setEmailAddress(emailAddress);

		logger.info("enregistrement du client {}", client);
		if (clientRepository.findByEmailAddress(emailAddress) != null) {
			logger.error("le client {} est deja enregistré dans la base de donnees", client);
			return new ResponseEntity(new ErrorClass("le client est deja enregistré dans la base de donnees"),
					HttpStatus.OK);
		}
		clientRepository.save(client);
		return new ResponseEntity(new SuccessClass("enregistrement "
				+ "effectué avec succès",client), HttpStatus.CREATED);
	}

	// methode d'ajout d'un nouveau client en post
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public ResponseEntity<?> addClientPost(HttpServletRequest request) {

		// recuperation des informations du client

		String firstNameCustomer = (String) request.getParameter("firstNameCustomer");
		String lastNameCustomer = (String) request.getParameter("lastNameCustomer");
		String phoneNumber = (String) request.getParameter("phoneNumber");
		String emailAddress = (String) request.getParameter("emailAddress");
		String password = (String) request.getParameter("password");
		//clientRepository.deleteAll();
		// instanciation du client à ajouter

		Client client = new Client();

		// action a menner apres reception des informations

		client.setFirstNameCustomer(firstNameCustomer);
		client.setLastNameCustomer(lastNameCustomer);
		client.setPhoneNumber(phoneNumber);
		client.setPassword(password);
		client.setEmailAddress(emailAddress);

		logger.info("enregistrement du client {}", client);
		if (clientRepository.findByEmailAddress(emailAddress) != null) {
			logger.error("le client {} est deja enregistré dans la base de donnees", client);
			return new ResponseEntity(new ErrorClass("le client est deja enregistré dans la base de donnees"),
					HttpStatus.OK);
		}
		clientRepository.save(client);
		return new ResponseEntity(new SuccessClass("enregistrement "
				+ "effectué avec succès",client), HttpStatus.CREATED);
	}

//**************************************************************************************************************
		// ******************************************************************************//
		// ***********************methode d'inscription à la news letter****************//
		// ******************************************************************************//

	// methode d'ajout d'un nouveau client en get
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/inscriptionToNewsletter", method = RequestMethod.GET)
	public ResponseEntity<?> inscriptionToNewsLetterGet(HttpServletRequest request) {

		// recuperation des informations du client
		String newsletterConcernEmail = (String) request.getParameter("newsletterConcernEmail");
		
		NewsletterConcern newsletterConcern = new NewsletterConcern(newsletterConcernEmail);


		logger.info("enregistrement de l'adresse email {}", newsletterConcernEmail);
		if (newsletterConcernRepository.findByNewsletterConcernEmail(newsletterConcernEmail) != null) {
			logger.error("l'adresse {} est deja enregistré dans la base de donnees", newsletterConcernEmail);
			return new ResponseEntity(new ErrorClass("l'adresse "
					+ newsletterConcernEmail +" est deja enregistré dans la base de donnees"),
					HttpStatus.OK);
		}
		newsletterConcernRepository.save(newsletterConcern);
		return new ResponseEntity(new SuccessClass("enregistrement "
				+ "effectué avec succès"), HttpStatus.OK);
	}

	
	// methode d'ajout d'un nouveau client en get
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/inscriptionToNewsletter", method = RequestMethod.POST)
	public ResponseEntity<?> inscriptionToNewsLetterPost(HttpServletRequest request) {

		// recuperation des informations du client
		String newsletterConcernEmail = (String) request.getParameter("newsletterConcernEmail");
		
		NewsletterConcern newsletterConcern = new NewsletterConcern(newsletterConcernEmail);


		logger.info("enregistrement de l'adresse email {}", newsletterConcernEmail);
		if (newsletterConcernRepository.findByNewsletterConcernEmail(newsletterConcernEmail) != null) {
			logger.error("l'adresse {} est deja enregistré dans la base de donnees", newsletterConcernEmail);
			return new ResponseEntity(new ErrorClass("l'adresse "
					+ newsletterConcernEmail +" est deja enregistré dans la base de donnees"),
					HttpStatus.OK);
		}
		newsletterConcernRepository.save(newsletterConcern);
		return new ResponseEntity(new SuccessClass("enregistrement "
				+ "effectué avec succès"), HttpStatus.OK);
	}



}
