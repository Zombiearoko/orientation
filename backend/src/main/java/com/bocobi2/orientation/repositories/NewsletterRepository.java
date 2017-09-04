package com.bocobi2.orientation.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bocobi2.orientation.model.Newsletter;

public interface NewsletterRepository extends MongoRepository<Newsletter, String> {

   
    public Newsletter findByNewsletterContent(String NewsletterContent);

}