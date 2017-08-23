package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Job;

public interface JobRepository extends MongoRepository<Job, String> {

    public Job findByjobName(String jobName);
    public List<Job> findByjobsector(String jobsector);

}