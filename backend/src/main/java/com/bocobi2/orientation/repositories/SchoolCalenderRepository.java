package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.SchoolCalender;

public interface SchoolCalenderRepository extends MongoRepository<SchoolCalender, String> {

    public SchoolCalender findByFirstName(String firstName);
    public List<SchoolCalender> findByLastName(String lastName);

}