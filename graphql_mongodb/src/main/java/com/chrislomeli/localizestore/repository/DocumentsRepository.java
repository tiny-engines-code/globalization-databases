package com.chrislomeli.localizestore.repository;

import com.chrislomeli.localizestore.model.Documents;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentsRepository  extends MongoRepository<Documents, String> {

}