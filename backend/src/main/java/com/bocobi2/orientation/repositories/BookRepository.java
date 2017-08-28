package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Book;


public interface BookRepository extends MongoRepository<Book, String> {

    public Book findByBookName(String bookName);
    public List<Book> findByBookAuthor(String bookAuthor);
    public void deleteByBookId(String bookId);
    
    

}