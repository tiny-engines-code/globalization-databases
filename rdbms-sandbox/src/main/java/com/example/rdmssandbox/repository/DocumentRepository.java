package com.example.rdmssandbox.repository;

import com.example.rdmssandbox.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, String> {

}