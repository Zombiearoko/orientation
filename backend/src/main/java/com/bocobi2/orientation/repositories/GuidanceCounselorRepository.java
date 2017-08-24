package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.GuidanceCounselor;

public interface GuidanceCounselorRepository extends MongoRepository<GuidanceCounselor, String> {

    public GuidanceCounselor findBylogin(String login);
    public List<GuidanceCounselor> findByguidanceCounselorId(String guidanceCounselorId);

}