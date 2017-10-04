package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;

public class TypeOfOrientation {
	
	@Id
	private String id;
	
	private String orientationName;

	public TypeOfOrientation() {}

	public String getOrientationName() {
		return orientationName;
	}

	public void setOrientationName(String orientationName) {
		this.orientationName = orientationName;
	}



}
