package com.example.mongosandbox.repository;

import com.example.mongosandbox.entity.Strings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StringsRepository extends MongoRepository<Strings, String> {

}
