package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

    public Client findByfirstNameCustomer(String firstNameCustomer);
    public List<Client> findBylastNameCustomer(String lastNameCustomer);

}