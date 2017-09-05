/**
 * 
 */
package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.NewsletterConcern;

@SuppressWarnings("unused")
public interface NewsletterConcernRepository extends MongoRepository<NewsletterConcern, String> {

	 public NewsletterConcern findByNewsletterConcernEmail(String newsletterConcernEmail);
	   
}
