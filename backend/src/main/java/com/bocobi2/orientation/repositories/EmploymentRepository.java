package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Employment;

public interface EmploymentRepository extends MongoRepository<Employment, String> {

    public Employment findByemploymentSector(String employmentSector);
    public List<Employment> findByemploymentName(String employmentName);

}