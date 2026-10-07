package com.ricardo.library.adapter.out.mongodb.repository;

import com.ricardo.library.adapter.out.mongodb.document.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SpringDataBookRepository extends MongoRepository<BookDocument, String> {

    Optional<BookDocument> findByIsbnValue(String isbn);
}