package com.bocobi2.orientation.model;

public class SuccessClass {

	private String successMessage;
	private Client customerInsession;
	
	

	public SuccessClass(Client client) {
		super();
		this.customerInsession = client;
	}

	public SuccessClass(String successMessage) {
		super();
		this.successMessage = successMessage;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public Client getCustomerInsession() {
		return customerInsession;
	}

	public void setCustomerInsession(Client customerInsession) {
		this.customerInsession = customerInsession;
	}
}
class successCustomer{
	
}
