package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "school")
public class School {

	@Id
	private String schoolId;
	private String schoolName;
	private String schoolType;
	private String schoolWebLink;
	
	public School(){}

	public School(String schoolName, String schoolType, String schoolWebLink) {
		super();
		this.schoolName = schoolName;
		this.schoolType = schoolType;
		this.schoolWebLink = schoolWebLink;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolType() {
		return schoolType;
	}

	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}

	public String getSchoolWebLink() {
		return schoolWebLink;
	}

	public void setSchoolWebLink(String schoolWebLink) {
		this.schoolWebLink = schoolWebLink;
	}
	
	 @Override
	    public String toString() {
	        return String.format(
	                "{\"schoolId\":%s, \"schoolName\":'%s', \"schoolType\":'%s',\"schoolWebLink\":'%s'}",
	                schoolId, schoolName, schoolType,schoolWebLink);
	    }

}
