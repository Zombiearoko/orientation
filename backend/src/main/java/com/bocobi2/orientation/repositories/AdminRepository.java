package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {

    public Admin findByLogin(String login);
    public List<Admin> findByPassword(String password);

}