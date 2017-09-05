package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class NewsletterConcern {

	@Id
	private String newsletterConcernId;
	private String newsletterConcernEmail;
	
	
	/**
	 * @param newsletterConcernEmail
	 */
	public NewsletterConcern(String newsletterConcernEmail) {
		super();
		this.newsletterConcernEmail = newsletterConcernEmail;
	}
	
	
	public String getNewsletterConcernEmail() {
		return newsletterConcernEmail;
	}
	public void setNewsletterConcernEmail(String newsletterConcernEmail) {
		this.newsletterConcernEmail = newsletterConcernEmail;
	}
	
	
	
}
