package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "job")
public class Job {
	
	@Id
	private String jobId;
	private String jobName;
	private String jobSector;
	
	public Job(){}

	public Job(String jobName, String jobSector) {
		super();
		this.jobName = jobName;
		this.jobSector = jobSector;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobSector() {
		return jobSector;
	}

	public void setJobSector(String jobSector) {
		this.jobSector = jobSector;
	}
	
	 @Override
	    public String toString() {
	        return String.format(
	                "{\"jobId\":%s, \"jobName\":'%s', \"jobSector\":'%s'}",
	                jobId, jobName, jobSector);
	    }

	
}
