package com.bocobi2.orientation.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Country;
import com.bocobi2.orientation.model.Department;
import com.bocobi2.orientation.model.Locality;
import com.bocobi2.orientation.model.Town;

public interface LocalityRepository extends MongoRepository<Locality, String> {
	public Locality findByCountry(Country country);
	public Town findByTown(Town town);
	public Department findByDepartment(Department department);
	
	public Locality findByIdLocalite(String idLocalite);
}
