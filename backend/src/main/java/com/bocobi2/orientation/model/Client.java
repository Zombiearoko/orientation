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
	
	
	
	

    public Client(String firstNameCustomer, String lastNameCustomer, String emailAddress, String password, String phoneNumber) {
		super();
		this.firstNameCustomer = firstNameCustomer;
		this.lastNameCustomer = lastNameCustomer;
		this.emailAddress = emailAddress;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public String getfirstNameCustomer() {
		return firstNameCustomer;
	}

	public void setfirstNameCustomer(String firstNameCustomer) {
		this.firstNameCustomer = firstNameCustomer;
	}

	public String getlastNameCustomer() {
		return lastNameCustomer;
	}

	public void setlastNameCustomer(String lastNameCustomer) {
		this.lastNameCustomer = lastNameCustomer;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmail(String email) {
		this.emailAddress = email;
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