package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Borough;
import com.bocobi2.orientation.model.Department;


public interface BoroughRepository extends MongoRepository<Borough, String> {
	
	public Borough findByBoroughName(String boroughName);
	
	public List<Borough> findByDepartment(Department department);
}
