<<<<<<< HEAD
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.TrainingCourse;

public interface TrainingCourseRepository extends MongoRepository<TrainingCourse, String> {


=======
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.TrainingCourse;

public interface TrainingCourseRepository extends MongoRepository<TrainingCourse, String> {

<<<<<<< HEAD
    public TrainingCourse findBytrainingCourseName(String trainingCourseName);
    public List<TrainingCourse> findBytrainingCourseId(String trainingCourseId);
=======
    public TrainingCourse findBytrainigCourseName(String trainigCourseName);
    public List<TrainingCourse> findBytrainigCourseId(String trainigCourseId);
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0

>>>>>>> 9bff8494973e510009f02e6104232262582327f1
}