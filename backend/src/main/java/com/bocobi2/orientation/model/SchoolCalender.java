package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "schoolCalender")
public class SchoolCalender {
	
	@Id
	private String schoolCalenderId;
	private String schoolCalenderName;
	private String schoolCalenderType;
	private String schoolCalenderYear;
	private String schoolCalenderFile;
	
	
	public SchoolCalender(){}
	
	
	public SchoolCalender(String schoolCalenderName, String schoolCalenderType, String schoolCalenderYear,
			String schoolCalenderFile) {
		super();
		this.schoolCalenderName = schoolCalenderName;
		this.schoolCalenderType = schoolCalenderType;
		this.schoolCalenderYear = schoolCalenderYear;
		this.schoolCalenderFile = schoolCalenderFile;
	}


	public String getSchoolCalenderId() {
		return schoolCalenderId;
	}

	public void setSchoolCalenderId(String schoolCalenderId) {
		this.schoolCalenderId = schoolCalenderId;
	}

	public String getSchoolCalenderName() {
		return schoolCalenderName;
	}

	public void setSchoolCalenderName(String schoolCalenderName) {
		this.schoolCalenderName = schoolCalenderName;
	}

	public String getSchoolCalenderType() {
		return schoolCalenderType;
	}

	public void setSchoolCalenderType(String schoolCalenderType) {
		this.schoolCalenderType = schoolCalenderType;
	}

	public String getSchoolCalenderYear() {
		return schoolCalenderYear;
	}

	public void setSchoolCalenderYear(String schoolCalenderYear) {
		this.schoolCalenderYear = schoolCalenderYear;
	}

	public String getSchoolCalenderFile() {
		return schoolCalenderFile;
	}

	public void setSchoolCalenderFile(String schoolCalenderFile) {
		this.schoolCalenderFile = schoolCalenderFile;
	}

	

	
		
	
}
