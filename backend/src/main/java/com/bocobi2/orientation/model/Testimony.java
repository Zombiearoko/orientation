package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testimony")
public class Testimony {

	@Id
	private String testimonyId;
	private String testimonyContent;
	private String testimonyAuthor;
	
	public Testimony(){}

	public Testimony(String testimonyContent, String testimonyAuthor) {
		super();
		this.testimonyContent = testimonyContent;
		this.testimonyAuthor = testimonyAuthor;
	}

	/**
	 * @return the testimonyContent
	 */
	public String getTestimonyContent() {
		return testimonyContent;
	}

	/**
	 * @param testimonyContent the testimonyContent to set
	 */
	public void setTestimonyContent(String testimonyContent) {
		this.testimonyContent = testimonyContent;
	}

	/**
	 * @return the testimonyAuthor
	 */
	public String getTestimonyAuthor() {
		return testimonyAuthor;
	}

	/**
	 * @param testimonyAuthor the testimonyAuthor to set
	 */
	public void setTestimonyAuthor(String testimonyAuthor) {
		this.testimonyAuthor = testimonyAuthor;
	}
	
	
	   @Override
	    public String toString() {
	        return String.format(
	                "{\"testimonyId\":%s, \"testimonyContent\":'%s', \"testimonyAuthor\":'%s'}",
	                testimonyId, testimonyContent, testimonyAuthor);
	    }

	
	
}
