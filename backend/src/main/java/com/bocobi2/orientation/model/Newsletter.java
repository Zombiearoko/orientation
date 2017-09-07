package com.bocobi2.orientation.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="newsletter")
public class Newsletter {

	@Id
	private String newsletterId;
	//private String newsletterContent;
	private List<String> listOfPrincipalActuality;
	private List<String> listOfPublication;
	private String newsletterStatus;
	public Newsletter() {
		super();
		// TODO Auto-generated constructor stub
		setListOfPrincipalActuality(new ArrayList<String>());
		setListOfPublication(new ArrayList<String>());
	}
	
	public Newsletter(String newsletterId) {
		super();
		this.newsletterId = newsletterId;
		setListOfPrincipalActuality(new ArrayList<String>());
		setListOfPublication(new ArrayList<String>());

	}

	public List<String> getListOfPrincipalActuality() {
		return listOfPrincipalActuality;
	}
	public void setListOfPrincipalActuality(List<String> listOfPrincipalActuality) {
		this.listOfPrincipalActuality = listOfPrincipalActuality;
	}
	public List<String> getListOfPublication() {
		return listOfPublication;
	}
	public void setListOfPublication(List<String> listOfPublication) {
		this.listOfPublication = listOfPublication;
	}
	public String getNewsletterStatus() {
		return newsletterStatus;
	}
	public void setNewsletterStatus(String newsletterStatus) {
		this.newsletterStatus = newsletterStatus;
	}
	
	
	
	
	
}
