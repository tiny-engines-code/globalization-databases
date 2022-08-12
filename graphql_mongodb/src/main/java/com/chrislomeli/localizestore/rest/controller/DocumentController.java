package com.chrislomeli.localizestore.rest.controller;

import com.chrislomeli.localizestore.model.Documents;
import com.chrislomeli.localizestore.service.DocumentsService;
import com.chrislomeli.structlog4j.ILogger;
import com.chrislomeli.structlog4j.SLoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(DocumentController.DRV)
public class DocumentController {

    private static final ILogger LOGGER = SLoggerFactory.getLogger(DocumentController.class);

    public static final String DOMAIN = "globalization";
    public static final String RESOURCE = "localize_documents";
    public static final String VERSION = "v3";
    public static final String RESOURCE_TYPE = DOMAIN + "/" + RESOURCE;
    public static final String DRV = "/" + RESOURCE_TYPE + "/" + VERSION;

    private final DocumentsService service;

    public DocumentController(DocumentsService service) {
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
            var response =  service.list(page);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Documents> get(@PathVariable(value = "id") String id) {
        try {
            Optional<Documents> foundObject = service.get(id);
            if (foundObject.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(foundObject.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Documents> create(@RequestBody Documents request) {
        try {
            var t = service.create(request);
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Documents> update(@RequestBody Documents request) {
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
