package com.chrislomeli.localizestore.service;

import com.chrislomeli.localizestore.model.Team;
import com.chrislomeli.localizestore.repository.TeamRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TeamService {

    private static final String NEXT_ANCHOR = "next";
    private static final String PREV_ANCHOR = "prev";
    private static final String TOTAL_PAGES_ATTRIBUTE = "totalPages";
    private static final String TOTAL_RESOURCES_ATTRIBUTE = "totalResources";

    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public Map<String, Object> list(Pageable page) {
            var t = repository.findAll(page);
            var data = t.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("data", data);
            response.put(PREV_ANCHOR, t.getNumber());
            response.put(NEXT_ANCHOR, t.nextPageable());
            response.put(TOTAL_RESOURCES_ATTRIBUTE, t.getTotalElements());
            response.put(TOTAL_PAGES_ATTRIBUTE, t.getTotalPages());            
            return response;
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
