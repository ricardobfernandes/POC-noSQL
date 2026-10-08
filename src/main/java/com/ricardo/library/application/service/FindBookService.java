package com.ricardo.library.application.service;

import com.ricardo.library.application.port.in.FindBookUseCase;
import com.ricardo.library.application.port.out.BookRepository;
import com.ricardo.library.domain.exception.ResourceNotFoundException;
import com.ricardo.library.domain.model.Book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindBookService implements FindBookUseCase {

	private final BookRepository bookRepository;

	public FindBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book findById(String id) {
		return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("Book not found with ISBN: " + isbn));
	}
}