package com.example.mongosandbox.repository;

import com.example.mongosandbox.entity.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {
    List<Document> findByName(String name);

}
