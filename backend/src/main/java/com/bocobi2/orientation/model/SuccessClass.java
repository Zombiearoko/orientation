package com.bocobi2.orientation.model;

public class SuccessClass {

	
	private int status = 1;
	private String successMessage;
	private Client customer;
	private Book book;
	
	public SuccessClass(String successMessage) {
		super();
		this.successMessage = successMessage;
	}

	public SuccessClass(Client customer) {
		super();
		this.customer = customer;
	}
	

	public SuccessClass(String successMessage, Client customer) {
		super();
		this.successMessage = successMessage;
		this.customer = customer;
	}
	
	

	public SuccessClass(String successMessage, Book book) {
		super();
		this.successMessage = successMessage;
		this.book = book;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public Client getCustomer() {
		return customer;
	}

	public void setCustomer(Client customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}

