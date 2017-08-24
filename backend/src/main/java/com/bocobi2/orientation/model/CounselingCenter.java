package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counselingCenter")

// La classe centre d'orientation
public class CounselingCenter {

	@Id
	private String counselingCenterId;
	private String counselingCenterName;
	private String counselingSector; // secteur d'orientation
	
	public CounselingCenter(){}

	public CounselingCenter(String counselingCenterName, String counselingSector) {
		super();
		this.counselingCenterName = counselingCenterName;
		this.counselingSector = counselingSector;
	}

	public String getCounselingCenterId() {
		return counselingCenterId;
	}

	public void setCounselingCenterId(String counselingCenterId) {
		this.counselingCenterId = counselingCenterId;
	}
	
	
	 @Override
	    public String toString() {
	        return String.format(
	                "{\"counselingCenterId\":%s, \"counselingCenterName\":'%s', \"counselingSetor\":'%s'}",
	                counselingCenterId, counselingCenterName, counselingSector);
	    }

}
