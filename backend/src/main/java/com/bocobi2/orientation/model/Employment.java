package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employment")
public class Employment {

	@Id
	private String employmentId;
	private String employmentName;
	private String employmentWebLink;
	private String employmentSector;
	
	public Employment(){}

	public Employment(String employmentName, String employmentWevLink, String employmentSector) {
		super();
		this.employmentName = employmentName;
		this.employmentWebLink = employmentWevLink;
		this.employmentSector = employmentSector;
	}

	/**
	 * @return the employmentName
	 */
	public String getEmploymentName() {
		return employmentName;
	}

	/**
	 * @param employmentName the employmentName to set
	 */
	public void setEmploymentName(String employmentName) {
		this.employmentName = employmentName;
	}

	/**
	 * @return the employmentWevLink
	 */
	public String getEmploymentWevLink() {
		return employmentWebLink;
	}

	/**
	 * @param employmentWevLink the employmentWevLink to set
	 */
	public void setEmploymentWevLink(String employmentWevLink) {
		this.employmentWebLink = employmentWevLink;
	}

	/**
	 * @return the employmentSector
	 */
	public String getEmploymentSector() {
		return employmentSector;
	}

	/**
	 * @param employmentSector the employmentSector to set
	 */
	public void setEmploymentSector(String employmentSector) {
		this.employmentSector = employmentSector;
	}
	
	
	 @Override
	    public String toString() {
	        return String.format(
	                "{\"employmentId\":%s, \"employmentName\":'%s', \"employmentWebLink\":'%s',\"employmentSector\":'%s'}",
	                employmentId, employmentName, employmentWebLink,employmentSector);
	    }

	}

