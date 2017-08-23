package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "scholarship")
public class Scholarship {

	@Id
	private String scholarshipId;
	private String scholarshipName;
	private String scholarshipType;
	private String scholarshipPublishingDate;
	private String scholarshipExpirationDate;
	private String scholarshipWebLink;
	
	public Scholarship(){}

	public Scholarship(String scholarshipName, String scholarshipType, String scholarshipPublishingDate,
			String scholarshipExpirationDate, String scholarshipWebLink) {
		super();
		this.scholarshipName = scholarshipName;
		this.scholarshipType = scholarshipType;
		this.scholarshipPublishingDate = scholarshipPublishingDate;
		this.scholarshipExpirationDate = scholarshipExpirationDate;
		this.scholarshipWebLink = scholarshipWebLink;
	}

	/**
	 * @return the scholarshipName
	 */
	public String getScholarshipName() {
		return scholarshipName;
	}

	/**
	 * @param scholarshipName the scholarshipName to set
	 */
	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}

	/**
	 * @return the scholarshipType
	 */
	public String getScholarshipType() {
		return scholarshipType;
	}

	/**
	 * @param scholarshipType the scholarshipType to set
	 */
	public void setScholarshipType(String scholarshipType) {
		this.scholarshipType = scholarshipType;
	}

	/**
	 * @return the scholarshipPublishingDate
	 */
	public String getScholarshipPublishingDate() {
		return scholarshipPublishingDate;
	}

	/**
	 * @param scholarshipPublishingDate the scholarshipPublishingDate to set
	 */
	public void setScholarshipPublishingDate(String scholarshipPublishingDate) {
		this.scholarshipPublishingDate = scholarshipPublishingDate;
	}

	/**
	 * @return the scholarshipExpirationDate
	 */
	public String getScholarshipExpirationDate() {
		return scholarshipExpirationDate;
	}

	/**
	 * @param scholarshipExpirationDate the scholarshipExpirationDate to set
	 */
	public void setScholarshipExpirationDate(String scholarshipExpirationDate) {
		this.scholarshipExpirationDate = scholarshipExpirationDate;
	}

	/**
	 * @return the scholarshipWebLink
	 */
	public String getScholarshipWebLink() {
		return scholarshipWebLink;
	}

	/**
	 * @param scholarshipWebLink the scholarshipWebLink to set
	 */
	public void setScholarshipWebLink(String scholarshipWebLink) {
		this.scholarshipWebLink = scholarshipWebLink;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("{scholarshipId:'%s',scholarshipName:'%s',scholarshipType:'%s',"
				+ "scholarshipPublishingDate:'%s',scholarshipExpirationDate:'%s',scholarshipWebLink:'%s'}",
				scholarshipId,scholarshipName,
				scholarshipType,scholarshipPublishingDate,scholarshipExpirationDate,scholarshipWebLink);
	}

	
	
	
}

