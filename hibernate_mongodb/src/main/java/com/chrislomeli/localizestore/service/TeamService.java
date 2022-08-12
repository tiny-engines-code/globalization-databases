package com.chrislomeli.localizestore.service;

import com.chrislomeli.localizestore.model.Team;
import com.chrislomeli.localizestore.repository.TeamRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public Page<Team> list(Pageable page) {
            return repository.findAll(page);
    }

    public Optional<Team> get(String id) {
          return repository.findById(id);
    }

    public Team create(Team request) {
            return repository.save(request);
    }

    public Team update(Team request) {
        return repository.save(request);
    }

    public ResponseEntity<HttpStatus> delete(String id) {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
}
