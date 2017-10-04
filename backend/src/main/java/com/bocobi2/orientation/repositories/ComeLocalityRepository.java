package com.bocobi2.orientation.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.bocobi2.orientation.model.ComeLocality;

public interface ComeLocalityRepository extends MongoRepository<ComeLocality, String> {
	
	public ComeLocality findById(String id);
}
