package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Scholarship;

public interface ScholarshipRepository extends MongoRepository<Scholarship, String> {

    public Scholarship findByScholarshipCalenderType(String ScholarshipCalenderType);
    public List<Scholarship> findByScholarshipCalenderYear(String ScholarshipCalenderYear);

}