package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Newsletter {

	@Id
	private String newsletterId;
	private String newsletterContent;
	
	
	
	
	/**
	 * @param newsletterContent
	 */
	public Newsletter(String newsletterContent) {
		super();
		this.newsletterContent = newsletterContent;
	}
	
	
	/**
	 * @return the newsletterContent
	 */
	public String getNewsletterContent() {
		return newsletterContent;
	}
	/**
	 * @param newsletterContent the newsletterContent to set
	 */
	public void setNewsletterContent(String newsletterContent) {
		this.newsletterContent = newsletterContent;
	}

}
