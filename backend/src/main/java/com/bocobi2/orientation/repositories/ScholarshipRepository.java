<<<<<<< HEAD
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Scholarship;

public interface ScholarshipRepository extends MongoRepository<Scholarship, String> {


=======
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Scholarship;

public interface ScholarshipRepository extends MongoRepository<Scholarship, String> {

<<<<<<< HEAD
    public Scholarship findByscholarshipType(String scholarshipType);
    public List<Scholarship> findByscholarshipPublishingDate(String scholarshipPublishingDate);
=======
    public Scholarship findByScholarshipCalenderType(String ScholarshipCalenderType);
    public List<Scholarship> findByScholarshipCalenderYear(String ScholarshipCalenderYear);
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0

>>>>>>> 9bff8494973e510009f02e6104232262582327f1
}