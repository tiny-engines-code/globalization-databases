package com.chrislomeli.localizestore.rest.controller;

import com.chrislomeli.localizestore.rest.request.TeamRequest;
import com.chrislomeli.localizestore.rest.response.TeamResponse;
import com.chrislomeli.localizestore.model.Team;
import com.chrislomeli.localizestore.repository.TeamRepository;
import com.chrislomeli.structlog4j.ILogger;
import com.chrislomeli.structlog4j.SLoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(TeamController.DRV)
public class TeamController {

    private static final ILogger LOGGER = SLoggerFactory.getLogger(TeamController.class);

    private static final String NEXT_ANCHOR = "next";
    private static final String PREV_ANCHOR = "prev";
    private static final String TOTAL_PAGES_ATTRIBUTE = "totalPages";
    private static final String TOTAL_RESOURCES_ATTRIBUTE = "totalResources";

    public static final String DOMAIN = "globalization";
    public static final String RESOURCE = "localize_teams";
    public static final String VERSION = "v3";
    public static final String RESOURCE_TYPE = DOMAIN + "/" + RESOURCE;
    public static final String DRV = "/" + RESOURCE_TYPE + "/" + VERSION;

    private final TeamRepository repository;

    public TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public ResponseEntity<Map<String,Object>> list(
            @RequestParam(value = "count", defaultValue = "25", required = false) final int count,
            @RequestParam(value = "anchor", defaultValue = "0", required = false) final int anchor,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) final String sortBy,
            @RequestParam(name = "filter", defaultValue = "", required = false) final List<String> filters)
    {
        try {
            // pages
            Pageable page = PageRequest.of(anchor, count, Sort.by(sortBy));

            // get from data
            var t = repository.findAll(page);
            if (t.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            var teams = t.getContent();

            // transform
            var responses = teams.stream().map(TeamResponse::new).collect(Collectors.toList());

            Map<String, Object> response = new HashMap<>();
            response.put("data", responses);
            response.put(PREV_ANCHOR, t.getNumber());
            response.put(NEXT_ANCHOR, t.nextPageable());
            response.put(TOTAL_RESOURCES_ATTRIBUTE, t.getTotalElements());
            response.put(TOTAL_PAGES_ATTRIBUTE, t.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TeamResponse> get(@PathVariable(value = "id") String id) {
        try {
            Optional<Team> foundObject = repository.findById(id);
            if (foundObject.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<TeamResponse>(new TeamResponse(foundObject.get()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<TeamResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<TeamResponse> create(@RequestBody TeamRequest request) {
        try {
            var t = repository.save(request.toRepository());
            return new ResponseEntity<>(new TeamResponse(t), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamResponse> update(@RequestBody TeamRequest request) {
        try {
            var t = repository.save(request.toRepository());
            return new ResponseEntity<>(new TeamResponse(t), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") String id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
