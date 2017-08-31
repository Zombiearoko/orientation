package com.bocobi2.orientation.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
public class Client {

    @Id
    private String emailAddress;

    private String firstNameCustomer;
    private String lastNameCustomer;
	private String password;
	private String phoneNumber;
	private List<Testimony> customerListOfTestimonies = new ArrayList<Testimony>();
	private List<Book> customerBasket = new ArrayList<Book>(); 
	
	
	public Client(){}
	

    public Client(String emailAddress, String firstNameCustomer, String lastNameCustomer, String password, String phoneNumber) {
		super();
		this.emailAddress = emailAddress;
		this.firstNameCustomer = firstNameCustomer;
		this.lastNameCustomer = lastNameCustomer;
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
	                "{\"firstNameCustomer\":'%s', \"lastNameCustomer\":'%s',"
	                + "\"emailAddress\":'%s',\"password\":'%s',\"phoneNumber\":'%s'}",
	                firstNameCustomer, lastNameCustomer,emailAddress,password,phoneNumber);
	    }


	public List<Testimony> getCustomerListOfTestimonies() {
		return customerListOfTestimonies;
	}


	public void setCustomerListOfTestimonies(List<Testimony> customerListOfTestimonies) {
		this.customerListOfTestimonies = customerListOfTestimonies;
	}
	
	public void postTestimony(Testimony testimony){
		this.customerListOfTestimonies.add(testimony);
	}


	public List<Book> getCustomerBasket() {
		return customerBasket;
	}


	public void setCustomerBasket(List<Book> customerBasket) {
		this.customerBasket = customerBasket;
	}
	
	public void addBookInBasket(Book book){
		this.customerBasket.add(book);
	}


}