package com.chrislomeli.localizestore.repository;

import com.chrislomeli.localizestore.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {

}