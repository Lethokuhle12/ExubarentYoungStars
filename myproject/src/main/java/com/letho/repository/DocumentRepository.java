package com.letho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letho.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    // Query to find documents by user ID
    List<Document> findByUserId(Long userId);

    // Query to find a document by document type (e.g., ID copy)
    Document findByUserIdAndDocumentType(Long userId, String documentType);
}