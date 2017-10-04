package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Country;
import com.bocobi2.orientation.model.Region;



public interface RegionRepository extends MongoRepository<Region, String>  {
	
	public Region findByRegionName(String regionName);
	
	public List<Region> findByCountry(Country country);
}
