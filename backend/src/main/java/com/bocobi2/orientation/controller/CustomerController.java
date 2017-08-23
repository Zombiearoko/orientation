package com.bocobi2.orientation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bocobi2.orientation.model.Client;
import com.bocobi2.orientation.repositories.*;


@RequestMapping("/customer")
@RestController
public class CustomerController {
	@Autowired
	private ClientRepository ClientRepository;

	private String errorMessage = "";
	private long phone = 0;

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}

	// methode d'ajout d'un nouveau client dans la base de donnees requete en
	// get
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET, params = { "firstNameCustomer",
			"lastNameCustomer", "phoneNumber", "emailAddress", "password" })
	public JSONObject addClientGet(HttpServletRequest request) {

		JSONObject result, success, errors;
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();

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

		try {
			clientRepository.save(client);
			success.put("succes message", "Client" + client.toString() + " was saved succesfully");
		} catch (Exception e) {
			errors.put("failedToSaveMessage", "Client" + client.toString() + "non enregistré");
		}

		// construction du message à renvoyer à la vue

		result.put("success", success);
		result.put("errors", errors);
		return result;
	}

	// methode d'ajout d'un nouveau client dans la base de donnees requete en
	// get
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, params = { "firstNameCustomer",
			"lastNameCustomer", "phoneNumber", "emailAdress", "password" })
	public JSONObject addClientPost(HttpServletRequest request) {

		JSONObject result, success, errors;
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();

		// recuperation des informations du client

		String firstNameCustomer = (String) request.getParameter("firstNameCustomer");
		String lastNameCustomer = (String) request.getParameter("lastNameCustomer");
		String phoneNumber = (String) request.getParameter("phoneNumber");
		String emailAdress = (String) request.getParameter("emailAdress");
		String password = (String) request.getParameter("password");

		// instanciation du client à ajouter

		Client client = new Client();

		// action a menner apres reception des informations

		client.setFirstNameCustomer(firstNameCustomer);
		client.setLastNameCustomer(lastNameCustomer);
		client.setPhoneNumber(phoneNumber);
		client.setPassword(password);
		client.setEmailAddress(emailAdress);

		try {
			clientRepository.save(client);
			success.put("succes message", "Client" + client.toString() + " was saved succesfully");
		} catch (Exception e) {
			errors.put("failedToSaveMessage", "Client" + client.toString() + "non enregistré");
		}

		// construction du message à renvoyer à la vue

		result.put("success", success);
		result.put("errors", errors);
		return result;
	}

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

		try {
			client = clientRepository.findByEmailAdress(login);
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
			client = clientRepository.findByEmailAdress(login);
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
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/postTestimony", method = RequestMethod.GET, params = { "testimonyContent" })
	private JSONObject postTestimony(HttpServletRequest request) {
		JSONObject result, success, errors;
		result = new JSONObject();
		success = new JSONObject();
		errors = new JSONObject();
		HttpSession session;
		
		session = request.getSession();
		Client client = (Client) session.getAttribute("customerInSession");
		

		result.put("success", success);
		result.put("errors", errors);
		return result;
	}
	
	// definition des methodes de controle des donnees recues de la vue
	private void validationpassword(String password) throws Exception {
		// TODO Auto-generated method stub

	}

	private void validatePasswordAndLogin(String password, String login) {
		// TODO Auto-generated method stub
		Client client = clientRepository.findByLogin(login);
		if (!client.getPassword().equals(password)) {
			throw new Exception("le mot de passe entré ne corespond pas au login");
		}
	}

}
