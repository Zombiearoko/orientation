package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.TrainingCourse;

public interface TrainingCourseRepository extends MongoRepository<TrainingCourse, String> {

    public TrainingCourse findBytrainigCourseName(String trainigCourseName);
    public List<TrainingCourse> findBytrainigCourseId(String trainigCourseId);

}