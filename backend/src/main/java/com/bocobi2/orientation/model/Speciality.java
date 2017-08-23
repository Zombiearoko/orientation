package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "speciality")
public class Speciality {

	@Id
	private String specialityId;
	private String specialitySector; // la serie , le secteur dans lequel se trouve une spécialité
	private String specialityDomain; // la filière 
	private String specialityOption; // option de la spécialité
	
	public Speciality(){}

	public Speciality(String specialitySector, String specialityDomain, String specialityOption) {
		super();
		this.specialitySector = specialitySector;
		this.specialityDomain = specialityDomain;
		this.specialityOption = specialityOption;
	}

	public String getSpecialitySector() {
		return specialitySector;
	}

	public void setSpecialitySector(String specialitySector) {
		this.specialitySector = specialitySector;
	}

	public String getSpecialityDomain() {
		return specialityDomain;
	}

	public void setSpecialityDomain(String specialityDomain) {
		this.specialityDomain = specialityDomain;
	}

	public String getSpecialityOption() {
		return specialityOption;
	}

	public void setSpecialityOption(String specialityOption) {
		this.specialityOption = specialityOption;
	}
	
	
	 @Override
	    public String toString() {
	        return String.format(
	                "{\"specialityId\":%s, \"specialitySector\":'%s', \"specialityDomain\":'%s',"
	                + "\"specialityOption\":'%s'}",
	                specialityId, specialitySector, specialityDomain,specialityOption);
	    }

	
	

}
