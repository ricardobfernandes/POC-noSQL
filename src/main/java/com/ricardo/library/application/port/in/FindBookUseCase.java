package com.ricardo.library.application.port.in;

import com.ricardo.library.domain.model.Book;

import java.util.List;

public interface FindBookUseCase {

	Book findById(String id);

	List<Book> findAll();

	Book findByIsbn(String isbn);
}