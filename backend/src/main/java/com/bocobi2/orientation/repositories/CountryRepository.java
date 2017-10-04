package com.bocobi2.orientation.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Country;

public interface CountryRepository extends MongoRepository<Country, String> {
	public Country findByCountryName(String countryName);
}
