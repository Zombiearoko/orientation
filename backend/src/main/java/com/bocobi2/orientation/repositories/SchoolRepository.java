package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.School;

public interface SchoolRepository extends MongoRepository<School, String> {

    public School findByschoolName(String schoolName);
    public List<School> findByschoolType(String schoolType);

}