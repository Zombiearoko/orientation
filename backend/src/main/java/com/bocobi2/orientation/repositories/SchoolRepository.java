package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.School;

public interface SchoolRepository extends MongoRepository<School, String> {

<<<<<<< HEAD
    public School findByschoolName(String schoolName);
    public List<School> findByschoolType(String schoolType);
=======
    public School findByschoolCalenderType(String schoolCalenderType);
    public List<School> findByschoolCalenderYear(String schoolCalenderYear);
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0

}