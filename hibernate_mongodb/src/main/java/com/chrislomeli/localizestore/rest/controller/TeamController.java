package com.chrislomeli.localizestore.rest.controller;

import com.chrislomeli.localizestore.model.Team;
import com.chrislomeli.localizestore.service.TeamService;
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

    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
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
            var t =  service.list(page);
            var data = t.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("data", data);
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
    public ResponseEntity<Team> get(@PathVariable(value = "id") String id) {
        try {
            Optional<Team> foundObject = service.get(id);
            if (foundObject.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(foundObject.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Team> create(@RequestBody Team request) {
        try {
            var t = service.create(request);
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> update(@RequestBody Team request) {
        try {
            var t = service.update(request);
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") String id) {
        try {
            return service.delete(id);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
