package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="socialPersonnality")
public class SocialPersonality {

	@Id
	private String idSocialPersonality;
	private int numberOfChild;
	private String profession;
	private String revenue;
	private String religion;
	private String AstrologicalSign;
	private boolean isSmoker;
	private String alimentaryPractice;
	private String school;
	private String cvFile;
	
	
	
	public SocialPersonality(int numberOfChild, String profession, String revenue, String religion,
			String astrologicalSign, boolean isSmoker, String alimentaryPractice, String school, String cvFile) {
		super();
		this.numberOfChild = numberOfChild;
		this.profession = profession;
		this.revenue = revenue;
		this.religion = religion;
		AstrologicalSign = astrologicalSign;
		this.isSmoker = isSmoker;
		this.alimentaryPractice = alimentaryPractice;
		this.school = school;
		this.cvFile = cvFile;
	}
	public SocialPersonality(String idSocialPersonality, int numberOfChild, String profession, String revenue,
			String religion, String astrologicalSign, boolean isSmoker, String alimentaryPractice, String school,
			String cvFile) {
		super();
		this.idSocialPersonality = idSocialPersonality;
		this.numberOfChild = numberOfChild;
		this.profession = profession;
		this.revenue = revenue;
		this.religion = religion;
		AstrologicalSign = astrologicalSign;
		this.isSmoker = isSmoker;
		this.alimentaryPractice = alimentaryPractice;
		this.school = school;
		this.cvFile = cvFile;
	}
	public SocialPersonality() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIdSocialPersonality() {
		return idSocialPersonality;
	}
	public void setIdSocialPersonality(String idSocialPersonality) {
		this.idSocialPersonality = idSocialPersonality;
	}
	public int getNumberOfChild() {
		return numberOfChild;
	}
	public void setNumberOfChild(int numberOfChild) {
		this.numberOfChild = numberOfChild;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getRevenue() {
		return revenue;
	}
	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getAstrologicalSign() {
		return AstrologicalSign;
	}
	public void setAstrologicalSign(String astrologicalSign) {
		AstrologicalSign = astrologicalSign;
	}
	public boolean isSmoker() {
		return isSmoker;
	}
	public void setSmoker(boolean isSmoker) {
		this.isSmoker = isSmoker;
	}
	public String getAlimentaryPractice() {
		return alimentaryPractice;
	}
	public void setAlimentaryPractice(String alimentaryPractice) {
		this.alimentaryPractice = alimentaryPractice;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCvFile() {
		return cvFile;
	}
	public void setCvFile(String cvFile) {
		this.cvFile = cvFile;
	}
	
	
}
