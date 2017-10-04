package com.bocobi2.orientation.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="profil")
public class Profil {

	@Id
	private String idProfil;
	
	private Date dateOfBirth;
	private Date dateOfInscription;
	private String proximity;
	
	@DBRef
	private SocialPersonality socialoPersonality;
	@DBRef
	private FamilyPersonality familyPersonality;
	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profil(String idProfil, Date dateOfBirth, Date dateOfInscription, String proximity,
			SocialPersonality socialoPersonality, FamilyPersonality familyPersonality) {
		super();
		this.idProfil = idProfil;
		this.dateOfBirth = dateOfBirth;
		this.dateOfInscription = dateOfInscription;
		this.proximity = proximity;
		this.socialoPersonality = socialoPersonality;
		this.familyPersonality = familyPersonality;
	}
	public Profil(Date dateOfBirth, Date dateOfInscription, String proximity, SocialPersonality socialoPersonality,
			FamilyPersonality familyPersonality) {
		super();
		this.dateOfBirth = dateOfBirth;
		this.dateOfInscription = dateOfInscription;
		this.proximity = proximity;
		this.socialoPersonality = socialoPersonality;
		this.familyPersonality = familyPersonality;
	}
	public String getIdProfil() {
		return idProfil;
	}
	public void setIdProfil(String idProfil) {
		this.idProfil = idProfil;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfInscription() {
		return dateOfInscription;
	}
	public void setDateOfInscription(Date dateOfInscription) {
		this.dateOfInscription = dateOfInscription;
	}
	public String getProximity() {
		return proximity;
	}
	public void setProximity(String proximity) {
		this.proximity = proximity;
	}
	public SocialPersonality getSocialoPersonality() {
		return socialoPersonality;
	}
	public void setSocialoPersonality(SocialPersonality socialoPersonality) {
		this.socialoPersonality = socialoPersonality;
	}
	public FamilyPersonality getFamilyPersonality() {
		return familyPersonality;
	}
	public void setFamilyPersonality(FamilyPersonality familyPersonality) {
		this.familyPersonality = familyPersonality;
	}
	
	
	
}
