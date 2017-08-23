package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guidanceCounselor")
public class GuidanceCounselor {

	
	@Id
	private String guidanceCounselorId;
	private String login;
	private String password;
	
	public GuidanceCounselor() {}
	public GuidanceCounselor(String login, String password) {
	
		this.login = login;
		this.setPassword(password);
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	   @Override
	    public String toString() {
	        return String.format(
	                "{\"guidanceCounselorId\":%s, \"login\":'%s', \"password\":'%s'}",
	                guidanceCounselorId, login, password);
	    }

	
	
	
	
}
