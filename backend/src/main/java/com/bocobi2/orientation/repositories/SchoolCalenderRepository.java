package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.SchoolCalender;

public interface SchoolCalenderRepository extends MongoRepository<SchoolCalender, String> {

<<<<<<< HEAD
    public SchoolCalender findBySchoolCalenderYear(String SchoolCalenderYear);
    public List<SchoolCalender> findBySchoolCalenderType(String SchoolCalenderType);
=======
    public SchoolCalender findByFirstName(String firstName);
    public List<SchoolCalender> findByLastName(String lastName);
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0

}