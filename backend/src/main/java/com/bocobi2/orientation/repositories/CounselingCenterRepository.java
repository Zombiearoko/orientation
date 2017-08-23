<<<<<<< HEAD
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.CounselingCenter;

public interface CounselingCenterRepository extends MongoRepository<CounselingCenter, String> {


=======
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.CounselingCenter;

public interface CounselingCenterRepository extends MongoRepository<CounselingCenter, String> {

    public CounselingCenter findBycounselingSector(String counselingSector);
<<<<<<< HEAD
    public List<CounselingCenter> findBycounselingCenterName(String counselingCenterName);
=======
    public List<CounselingCenter> findBycounselingName(String counselingName);
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0

>>>>>>> 9bff8494973e510009f02e6104232262582327f1
}