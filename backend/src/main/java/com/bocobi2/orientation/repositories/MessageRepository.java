package com.bocobi2.orientation.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bocobi2.orientation.model.Message;

public interface MessageRepository extends MongoRepository<Message, String> {

    public Message findBymessageContent(String messageContent);
    public List<Message> findByidMessage(String idMessage);

}