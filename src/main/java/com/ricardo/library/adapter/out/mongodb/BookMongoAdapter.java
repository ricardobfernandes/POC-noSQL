package com.ricardo.library.adapter.out.mongodb;

import com.ricardo.library.adapter.out.mongodb.document.BookDocument;
import com.ricardo.library.adapter.out.mongodb.repository.SpringDataBookRepository;
import com.ricardo.library.application.port.out.BookRepository;
import com.ricardo.library.domain.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookMongoAdapter implements BookRepository {

	private final SpringDataBookRepository repository;

	public BookMongoAdapter(SpringDataBookRepository repository) {
		this.repository = repository;
	}

	@Override
	public Book save(Book book) {
		BookDocument document = BookMongoMapper.toDocument(book);
		BookDocument saved = repository.save(document);
		return BookMongoMapper.toDomain(saved);
	}

	@Override
	public Optional<Book> findById(String id) {
		return repository.findById(id).map(BookMongoMapper::toDomain);
	}

	@Override
	public List<Book> findAll() {
		return repository.findAll().stream().map(BookMongoMapper::toDomain).toList();
	}

	@Override
	public Optional<Book> findByIsbn(String isbn) {
		return repository.findByIsbnValue(isbn).map(BookMongoMapper::toDomain);
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}
}