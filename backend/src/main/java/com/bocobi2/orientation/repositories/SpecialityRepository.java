package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Speciality;

public interface SpecialityRepository extends MongoRepository<Speciality, String> {

    public Speciality findByspecialitySector(String specialitySector);
    public List<Speciality> findByspecialityId(String lastName);

}