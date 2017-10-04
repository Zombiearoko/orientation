package com.bocobi2.orientation.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "familiPersonality")
public class FamilyPersonality {

	private String idFamilyPersoality;
	private String namoOfGrandFather;
	private String fatherName;
	private String motherName;
	private String fatherVitalStatus;
	private String motherVitalStatus;
	
	public FamilyPersonality() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public FamilyPersonality(String namoOfGrandFather, String fatherName, String motherName, String fatherVitalStatus,
			String motherVitalStatus) {
		super();
		this.namoOfGrandFather = namoOfGrandFather;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.fatherVitalStatus = fatherVitalStatus;
		this.motherVitalStatus = motherVitalStatus;
	}


	public String getIdFamilyPersoality() {
		return idFamilyPersoality;
	}


	public void setIdFamilyPersoality(String idFamilyPersoality) {
		this.idFamilyPersoality = idFamilyPersoality;
	}


	public String getNamoOfGrandFather() {
		return namoOfGrandFather;
	}


	public void setNamoOfGrandFather(String namoOfGrandFather) {
		this.namoOfGrandFather = namoOfGrandFather;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getFatherVitalStatus() {
		return fatherVitalStatus;
	}


	public void setFatherVitalStatus(String fatherVitalStatus) {
		this.fatherVitalStatus = fatherVitalStatus;
	}


	public String getMotherVitalStatus() {
		return motherVitalStatus;
	}


	public void setMotherVitalStatus(String motherVitalStatus) {
		this.motherVitalStatus = motherVitalStatus;
	}



}

