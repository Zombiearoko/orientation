package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
public class Client {

    @Id
    private String idClient;

    private String firstNameCustomer;
    private String lastNameCustomer;
    private String emailAddress;
	private String password;
	private String phoneNumber;
	
	
	
	
    public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


    public Client(String firstNameCustomer, String lastNameCustomer, String emailAddress, String password,
			String phoneNumber) {
		super();
		this.firstNameCustomer = firstNameCustomer;
		this.lastNameCustomer = lastNameCustomer;
		this.emailAddress = emailAddress;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

    public String getIdClient() {
		return idClient;
	}


	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}


	public String getFirstNameCustomer() {
		return firstNameCustomer;
	}


	public void setFirstNameCustomer(String firstNameCustomer) {
		this.firstNameCustomer = firstNameCustomer;
	}


	public String getLastNameCustomer() {
		return lastNameCustomer;
	}


	public void setLastNameCustomer(String lastNameCustomer) {
		this.lastNameCustomer = lastNameCustomer;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String toString() {
        return String.format(
                "Admin[id=%s, password='%s', password='%s']",
                idClient, firstNameCustomer, password);
    }
    
} 