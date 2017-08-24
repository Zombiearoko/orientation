package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.SchoolCalender;

public interface SchoolCalenderRepository extends MongoRepository<SchoolCalender, String> {

    public SchoolCalender findBySchoolCalenderYear(String SchoolCalenderYear);
    public List<SchoolCalender> findBySchoolCalenderType(String SchoolCalenderType);


}