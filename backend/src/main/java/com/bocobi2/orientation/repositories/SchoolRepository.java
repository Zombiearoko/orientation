package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.School;

public interface SchoolRepository extends MongoRepository<School, String> {

    public School findBySchoolName(String schoolName);
    public List<School> findBySchoolType(String schoolType);

}