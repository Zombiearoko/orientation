<<<<<<< HEAD
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Administrator;

public interface AdministratorRepository extends MongoRepository<Administrator, String> {

    public Administrator findByLogin(String login);
    public List<Administrator> findByPassword(String password);

=======
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Administrator;


public interface AdministratorRepository extends MongoRepository<Administrator, String> {

    public Administrator findByLogin(String login);
    public List<Administrator> findByPassword(String password);
    

>>>>>>> 1305f807e59d31c3eb7107fcee1b2e8a68e0f2d0
}