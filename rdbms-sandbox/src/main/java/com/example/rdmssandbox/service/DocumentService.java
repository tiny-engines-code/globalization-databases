package com.example.rdmssandbox.service;


import com.example.rdmssandbox.entity.Document;
import com.example.rdmssandbox.entity.Department;
import com.example.rdmssandbox.entity.Strings;
import com.example.rdmssandbox.repository.DepartmentRepository;
import com.example.rdmssandbox.repository.DocumentRepository;

import com.example.rdmssandbox.repository.StringsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final StringsRepository stringsRepository;
    private final DepartmentRepository departmentRepository;

    public DocumentService(DocumentRepository documentRepository, StringsRepository stringsRepository, DepartmentRepository departmentRepository) {
        this.documentRepository = documentRepository;
        this.stringsRepository = stringsRepository;
        this.departmentRepository = departmentRepository;
    }


    public Document createDocument(Document document) {
        Department metaData = null;
        if (document.getDepartment() != null ) {
            var s = document.getDepartment();
             metaData = departmentRepository.save(s);
        }

        var insertedDocument = documentRepository.save(Document.builder()
                        .name(document.getName())
                        .email(document.getEmail())
                        .department(metaData)
                .build());

        List<Strings> insertedStrings = new ArrayList();
        if (document.getStrings() != null && !document.getStrings().isEmpty()) {
            for (Strings s : document.getStrings()) {
                s.setDocumentId(insertedDocument.getId());
                var saved = stringsRepository.save(s);
                insertedStrings.add(saved);
            }
        }



        insertedDocument.setStrings(insertedStrings);
        insertedDocument.setDepartment(metaData);
        return insertedDocument;
    }

    public List<Document> getDocuments() {
        return documentRepository.findAll();
    }

    public Document getDocument(String id) {
        var s = documentRepository.findById(id);
        return s.orElse(null);
    }

    public String removeDocument(String id) {
        documentRepository.deleteById(id);
        return "deleted";
    }

    public Document updateDocument(Document Document) {
        return documentRepository.save(Document);
    }

}
