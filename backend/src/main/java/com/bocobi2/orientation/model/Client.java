<<<<<<< HEAD
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
=======
package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
public class Client {

    @Id
    private String ClientId;

    private String firstNameCustomer;
    private String lastNameCustomer;
    private String emailAddress;
	private String password;
	private String phoneNumber;
	
	
	public Client(){}
	

    public Client(String firstNameCustomer, String lastNameCustomer, String emailAddress, String password, String phoneNumber) {
		super();
		this.firstNameCustomer = firstNameCustomer;
		this.lastNameCustomer = lastNameCustomer;
		this.emailAddress = emailAddress;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
    
    


    /**
	 * @return the firstNameCustomer
	 */
	public String getFirstNameCustomer() {
		return firstNameCustomer;
	}


	/**
	 * @param firstNameCustomer the firstNameCustomer to set
	 */
	public void setFirstNameCustomer(String firstNameCustomer) {
		this.firstNameCustomer = firstNameCustomer;
	}


	/**
	 * @return the lastNameCustomer
	 */
	public String getLastNameCustomer() {
		return lastNameCustomer;
	}


	/**
	 * @param lastNameCustomer the lastNameCustomer to set
	 */
	public void setLastNameCustomer(String lastNameCustomer) {
		this.lastNameCustomer = lastNameCustomer;
	}


	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}


	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	   @Override
	    public String toString() {
	        return String.format(
	                "{\"clientId\":%s, \"firstNameCustomer\":'%s', \"lastNameCustomer\":'%s',"
	                + "\"emailAddress\":'%s',\"password\":'%s',\"phoneNumber\":'%s'}",
	                ClientId, firstNameCustomer, lastNameCustomer,emailAddress,password,phoneNumber);
	    }
}
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0
