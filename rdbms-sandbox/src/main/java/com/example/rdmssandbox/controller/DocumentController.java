package com.example.rdmssandbox.controller;

import com.example.rdmssandbox.entity.Document;
import com.example.rdmssandbox.service.DocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService service) {
        this.documentService = service;
    }

    @PostMapping("")
    public Document createDocument(@RequestBody Document Document) {
        return documentService.createDocument(Document);
    }

    @GetMapping("")
    public List<Document> getAllDocuments() {
        return documentService.getDocuments();
    }

    @GetMapping("/{id}")
    public Document getDocument(@PathVariable String id) {
        return documentService.getDocument(id);
    }


    @DeleteMapping("/{id}")
    public String removeDocument(@PathVariable String id) {
        return documentService.removeDocument(id);
    }

    @PutMapping("")
    public Document getDocument(@RequestBody Document Document) {
        return documentService.updateDocument(Document);
    }

}
