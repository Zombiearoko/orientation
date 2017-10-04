package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="connectionStatus")
public class ConnectionStatus {


	@Id
	private String statusId;
	private String statusName;
	
	public ConnectionStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConnectionStatus(String statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public ConnectionStatus(String statusName) {
		super();
		this.statusName = statusName;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}
