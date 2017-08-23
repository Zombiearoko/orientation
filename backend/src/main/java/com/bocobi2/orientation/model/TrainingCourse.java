package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trainigCourse")
public class TrainingCourse {
	
	@Id
	private String trainingCourseId;
	private String trainigCourseName;
	private String trainigCourseBeginningDate;
	private String trainigCourseEndingDate;
	private String trainigCourseWebLink;
	
	public TrainingCourse(){}

	public TrainingCourse(String trainigCourseName, String trainigCourseBeginningDate, String trainigCourseEndingDate,
			String trainigCourseWebLink) {
		super();
		this.trainigCourseName = trainigCourseName;
		this.trainigCourseBeginningDate = trainigCourseBeginningDate;
		this.trainigCourseEndingDate = trainigCourseEndingDate;
		this.trainigCourseWebLink = trainigCourseWebLink;
	}

	public String getTrainigCourseName() {
		return trainigCourseName;
	}

	public void setTrainigCourseName(String trainigCourseName) {
		this.trainigCourseName = trainigCourseName;
	}

	public String getTrainigCourseBeginningDate() {
		return trainigCourseBeginningDate;
	}

	public void setTrainigCourseBeginningDate(String trainigCourseBeginningDate) {
		this.trainigCourseBeginningDate = trainigCourseBeginningDate;
	}

	public String getTrainigCourseEndingDate() {
		return trainigCourseEndingDate;
	}

	public void setTrainigCourseEndingDate(String trainigCourseEndingDate) {
		this.trainigCourseEndingDate = trainigCourseEndingDate;
	}

	public String getTrainigCourseWebLink() {
		return trainigCourseWebLink;
	}

	public void setTrainigCourseWebLink(String trainigCourseWebLink) {
		this.trainigCourseWebLink = trainigCourseWebLink;
	}
	
	
	 @Override
	    public String toString() {
	        return String.format(
	                "{\"trainingCouseId\":%s, \"trainingCourseName\":'%s', \"traininCourseBeginnigDate\":'%s',"
	                + "\"trainingCourseEndingDate\":'%s'}",
	                trainingCourseId, trainigCourseName, trainigCourseEndingDate,trainigCourseEndingDate);
	    }

}
