package com.ricardo.library.application.service;

import com.ricardo.library.application.port.in.UpdateBookUseCase;
import com.ricardo.library.application.port.out.BookRepository;
import com.ricardo.library.domain.exception.ResourceNotFoundException;
import com.ricardo.library.domain.model.*;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateBookService implements UpdateBookUseCase {

	private final BookRepository bookRepository;

	public UpdateBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book update(String id, UpdateBookCommand command) {

		Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found: " + id));
		List<Author> authors = command.authors().stream().map(Author::new).toList();
		book.update(command.title(), new Isbn(command.isbn()), authors, new Category(command.category()), new Publication(command.publicationYear(), command.publisher()));
		return bookRepository.save(book);
	}
}