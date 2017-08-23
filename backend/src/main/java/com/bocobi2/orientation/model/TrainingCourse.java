package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trainigCourse")
public class TrainingCourse {
	
	@Id
	private String trainingCourseId;
	private String trainingCourseName;
	private String trainingCourseBeginningDate;
	private String trainingCourseEndingDate;
	private String trainingCourseWebLink;
	
	public TrainingCourse(){}

	public TrainingCourse(String trainigCourseName, String trainigCourseBeginningDate, String trainigCourseEndingDate,
			String trainigCourseWebLink) {
		super();
		this.trainingCourseName = trainigCourseName;
		this.trainingCourseBeginningDate = trainigCourseBeginningDate;
		this.trainingCourseEndingDate = trainigCourseEndingDate;
		this.trainingCourseWebLink = trainigCourseWebLink;
	}

	public String getTrainigCourseName() {
		return trainingCourseName;
	}

	public void setTrainigCourseName(String trainigCourseName) {
		this.trainingCourseName = trainigCourseName;
	}

	public String getTrainigCourseBeginningDate() {
		return trainingCourseBeginningDate;
	}

	public void setTrainigCourseBeginningDate(String trainigCourseBeginningDate) {
		this.trainingCourseBeginningDate = trainigCourseBeginningDate;
	}

	public String getTrainigCourseEndingDate() {
		return trainingCourseEndingDate;
	}

	public void setTrainigCourseEndingDate(String trainigCourseEndingDate) {
		this.trainingCourseEndingDate = trainigCourseEndingDate;
	}

	public String getTrainigCourseWebLink() {
		return trainingCourseWebLink;
	}

	public void setTrainigCourseWebLink(String trainigCourseWebLink) {
		this.trainingCourseWebLink = trainigCourseWebLink;
	}
	
	
	 @Override
	    public String toString() {
	        return String.format(
	                "{\"trainingCouseId\":%s, \"trainingCourseName\":'%s', \"traininCourseBeginnigDate\":'%s',"
	                + "\"trainingCourseEndingDate\":'%s'}",
	                trainingCourseId, trainingCourseName, trainingCourseEndingDate,trainingCourseEndingDate);
	    }

}
