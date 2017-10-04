package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Concession;
import com.bocobi2.orientation.model.Town;


public interface ConcessionRepository extends MongoRepository<Concession, String>  {
	
	public Concession findByConcessionName(String ConcessionName);
	
	public List<Concession> findByTown(Town town);

}
