package com.bocobi2.orientation.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
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
	//methode pour le choix du type d'orientation en get
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@RequestMapping(value = "/choiceOfTypeOfOrientation", method = RequestMethod.GET)
		public ResponseEntity<?> choiceOfTypeOfOrientationGet(HttpServletRequest request) {
			
			return null;

		}

	//methode pour le choix du type d'orientation en post
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/choiceOfTypeOfOrientation", method = RequestMethod.POST)
	public ResponseEntity<?> choiceOfTypeOfOrientationPost(HttpServletRequest request) {

		// recuperation des informations du client
		
		String typeOfOrientation = (String) request.getParameter("typeOfOrientation");
		String emailAddress = request.getParameter("emailAdress");
		
		Client client = new Client(emailAddress,typeOfOrientation);
		logger.info("enregistrement du type d'orientation choisi"
				+ " par le client d'adresse email {}", emailAddress);
		if (clientRepository.findByEmailAddress(emailAddress) != null) {
			logger.error("le client d'adresse {} est deja enregistré"
					+ " dans la base de donnees", emailAddress);
			return new ResponseEntity(new ErrorClass("le client d'adresse "
					+ emailAddress +" est deja enregistré dans la base de donnees"),
					HttpStatus.OK);
		}
		
		clientRepository.save(client);
		return new ResponseEntity(new SuccessClass("enregistrement "
				+ "effectué avec succès",client), HttpStatus.OK);
	}

	// methode d'ajout d'un nouveau client en get
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public ResponseEntity<?> addClientGet(HttpServletRequest request) {

		return null;
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
		NewsletterConcern newsletterConcern = new NewsletterConcern(emailAddress);

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
		newsletterConcernRepository.save(newsletterConcern);
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		//properties.put("mail.smtp.host", "smtp-relay.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.required", "false");
		properties.put("mail.smtp.connectiontimeout", "5000");
		properties.put("mail.smtp.timeout", "5000");
		properties.put("mail.smtp.writetimeout", "5000");
		Session session = Session.getInstance(properties, null);

		String content1 = "Thanks to create your count in our "
				+ "website! your password is "+client.getPassword();
		String subject1 = "inscription sur le site d'orientation bocobi2 reussie!!!";
		// String form="saphirmfogo@gmail.com";
		MimeMessage msg = new MimeMessage(session);
		/// msg.setFrom(new InternetAddress(form));
		try {
			msg.setRecipients(MimeMessage.RecipientType.TO, emailAddress);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg.setSubject(subject1);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg.setText(content1);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			msg.setSentDate(new Date());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Transport transport = null;
		try {
			transport = session.getTransport("smtp");
		} catch (NoSuchProviderException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			transport.connect("smtp.gmail.com", "tialoinnocent@gmail.com", "28640000");
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			transport.sendMessage(msg, msg.getAllRecipients());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			transport.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return new ResponseEntity(new SuccessClass("enregistrement "
				+ "effectué avec succès",client), HttpStatus.CREATED);
	}
//**************************************************************************************************************
		// ******************************************************************************//
		// ***********************methode d'inscription à la news letter****************//
		// ******************************************************************************//

	// methode d'inscription à la newsletter en get
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

	
	// methode d'inscripotion à la newsletter en post
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
