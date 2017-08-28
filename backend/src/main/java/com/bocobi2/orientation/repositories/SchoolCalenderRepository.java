package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.SchoolCalender;

public interface SchoolCalenderRepository extends MongoRepository<SchoolCalender, String> {


    public List<SchoolCalender> findBySchoolCalenderYear(String schoolCalenderYear);
    public List<SchoolCalender> findBySchoolCalenderType(String schoolCalenderType);
	public SchoolCalender findBySchoolCalenderName(String schoolCalenderName);
	public void deleteByschoolCalenderId(String schoolCalenderId);



}