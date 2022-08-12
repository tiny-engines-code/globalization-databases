package com.chrislomeli.localizestore.repository;

import com.chrislomeli.localizestore.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, String> {

}