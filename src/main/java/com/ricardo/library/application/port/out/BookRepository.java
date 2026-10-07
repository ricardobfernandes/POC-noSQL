package com.ricardo.library.application.port.out;

import com.ricardo.library.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
	//hexagonal

	Book save(Book book);

	Optional<Book> findById(String id);

	List<Book> findAll();

	Optional<Book> findByIsbn(String isbn);

	void deleteById(String id);
}