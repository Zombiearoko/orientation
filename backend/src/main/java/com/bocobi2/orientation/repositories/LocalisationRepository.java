package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Localisation;

public interface LocalisationRepository extends MongoRepository<Localisation, String> {

    public Localisation findBycountry(String country);
    public List<Localisation> findBytown(String town);

}