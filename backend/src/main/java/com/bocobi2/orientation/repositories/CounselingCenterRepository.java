package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.CounselingCenter;

public interface CounselingCenterRepository extends MongoRepository<CounselingCenter, String> {

    public CounselingCenter findBycounselingSector(String counselingSector);
    public List<CounselingCenter> findBycounselingName(String counselingName);

}