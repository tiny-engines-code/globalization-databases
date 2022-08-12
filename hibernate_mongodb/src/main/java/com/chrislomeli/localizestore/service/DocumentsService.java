package com.chrislomeli.localizestore.service;

import com.chrislomeli.localizestore.model.Documents;
import com.chrislomeli.localizestore.repository.DocumentsRepository;
import com.chrislomeli.localizestore.repository.ProjectRepository;
import com.chrislomeli.localizestore.rest.request.DocumentsRequest;
import com.chrislomeli.localizestore.rest.response.DocumentsResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DocumentsService {


    private final DocumentsRepository documentsRepository;
    private final ProjectRepository projectRepository;

    public DocumentsService(DocumentsRepository documentsRepository, ProjectRepository projectRepository) {
        this.documentsRepository = documentsRepository;
        this.projectRepository = projectRepository;
    }

    public Page<Documents> list(Pageable page) {
        return documentsRepository.findAll(page);

    }

    public Optional<Documents> get(String id) {
          return documentsRepository.findById(id);
    }

    public Documents create(Documents request) {
            return documentsRepository.save(request);
    }

    public DocumentsResponse createDocument(DocumentsRequest request) {
        var projectId = request.getParentId();
        var projectobject = projectRepository.findById(projectId);
        if (projectobject.isPresent()) {
            var project = projectobject.get();
            var document =   documentsRepository.save(request.toRepository());
            project.addDocument(document);
            projectRepository.save(project);
            return new DocumentsResponse(project);
        }
        return null;
    }
    

    public Documents update(Documents request) {
        return documentsRepository.save(request);
    }

    public ResponseEntity<HttpStatus> delete(String id) {
            if (documentsRepository.existsById(id)) {
                documentsRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
}
