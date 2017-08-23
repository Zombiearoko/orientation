<<<<<<< HEAD
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
=======
package com.bocobi2.orientation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trainigCourse")
public class TrainingCourse {
	
	@Id
	private String trainingCourseId;
<<<<<<< HEAD
	private String trainingCourseName;
	private String trainingCourseBeginningDate;
	private String trainingCourseEndingDate;
	private String trainingCourseWebLink;
=======
	private String trainigCourseName;
	private String trainigCourseBeginningDate;
	private String trainigCourseEndingDate;
	private String trainigCourseWebLink;
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0
	
	public TrainingCourse(){}

	public TrainingCourse(String trainigCourseName, String trainigCourseBeginningDate, String trainigCourseEndingDate,
			String trainigCourseWebLink) {
		super();
<<<<<<< HEAD
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
=======
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
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0
	}
	
	
	 @Override
	    public String toString() {
	        return String.format(
	                "{\"trainingCouseId\":%s, \"trainingCourseName\":'%s', \"traininCourseBeginnigDate\":'%s',"
	                + "\"trainingCourseEndingDate\":'%s'}",
<<<<<<< HEAD
	                trainingCourseId, trainingCourseName, trainingCourseEndingDate,trainingCourseEndingDate);
=======
	                trainingCourseId, trainigCourseName, trainigCourseEndingDate,trainigCourseEndingDate);
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0
	    }

}
>>>>>>> 9bff8494973e510009f02e6104232262582327f1
