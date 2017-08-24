package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "schoolCalender")
public class SchoolCalender {
	
	@Id
	private String SchoolCalenderId;
	private String SchoolCalenderType;
	private String SchoolCalenderYear;
	private String SchoolCalenderFile;
	
	public SchoolCalender(){}

	
		
	 public SchoolCalender(String schoolCalenderType, String schoolCalenderYear, String schoolCalenderFile) {
		super();
		SchoolCalenderType = schoolCalenderType;
		SchoolCalenderYear = schoolCalenderYear;
		SchoolCalenderFile = schoolCalenderFile;
	}



	public String getSchoolCalenderType() {
		return SchoolCalenderType;
	}

	public void setSchoolCalenderType(String schoolCalenderType) {
		SchoolCalenderType = schoolCalenderType;
	}

	public String getSchoolCalenderYear() {
		return SchoolCalenderYear;
	}

	public void setSchoolCalenderYear(String schoolCalenderYear) {
		SchoolCalenderYear = schoolCalenderYear;
	}

	public String getSchoolCalenderFile() {
		return SchoolCalenderFile;
	}

	public void setSchoolCalenderFile(String schoolCalenderFile) {
		SchoolCalenderFile = schoolCalenderFile;
	}

	@Override
	    public String toString() {
	        return String.format(
	                "{\"SchoolCalenderId\":%s, \"SchoolCalenderType\":'%s', "
	                + "\"SchoolCalenderYear\":'%s',\"SchoolCalenderFile\":'%s'}",
	                SchoolCalenderId, SchoolCalenderType, SchoolCalenderYear,SchoolCalenderFile);
	    }

	
}
