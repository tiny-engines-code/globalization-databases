package com.example.mongosandbox.service;

import com.example.mongosandbox.entity.Document;
import com.example.mongosandbox.repository.DocumentRepository;
import com.example.mongosandbox.repository.StringsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository DocumentRepository;
    private final StringsRepository subjectRepository;

    public DocumentService(DocumentRepository repository, StringsRepository subjectRepository) {
        this.DocumentRepository = repository;
        this.subjectRepository = subjectRepository;
    }

    public Document createDocument(Document Document) {
        if (Document.getStrings() != null && !Document.getStrings().isEmpty()) {
            subjectRepository.saveAll(Document.getStrings());
        }
        return DocumentRepository.save(Document);
    }
    public List<Document> getDocuments() {
        return DocumentRepository.findAll();
    }

    public Document getDocument(String id) {
        var s = DocumentRepository.findById(id);
        return s.orElse(null);
    }

    public String removeDocument(String id) {
        DocumentRepository.deleteById(id);
        return "deleted";
    }

    public Document updateDocument(Document Document) {
        return DocumentRepository.save(Document);
    }

    public List<Document> getDocumentsByName(String name) {
        return DocumentRepository.findByName(name);
    }

}
