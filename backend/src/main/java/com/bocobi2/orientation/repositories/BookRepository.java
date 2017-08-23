package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Book;


public interface BookRepository extends MongoRepository<Book, String> {

    public Book findBybookName(String bookName);
    public List<Book> findBybookAuthor(String bookAuthor);
    
    

}