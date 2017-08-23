<<<<<<< HEAD
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Job;

public interface JobRepository extends MongoRepository<Job, String> {

=======
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Job;

public interface JobRepository extends MongoRepository<Job, String> {

    public Job findByjobName(String jobName);
<<<<<<< HEAD
    public List<Job> findByjobSector(String jobSector);
=======
    public List<Job> findByjobsector(String jobsector);
>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0

>>>>>>> 9bff8494973e510009f02e6104232262582327f1
}