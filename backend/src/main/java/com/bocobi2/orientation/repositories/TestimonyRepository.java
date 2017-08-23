package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Testimony;

public interface TestimonyRepository extends MongoRepository<Testimony, String> {

    public Testimony findBytestimonyId(String testimonyId);
    public List<Testimony> findBytestimonyAuthor(String testimonyAuthor);

}