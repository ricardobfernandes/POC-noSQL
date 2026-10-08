package com.ricardo.library.application.service;

import com.ricardo.library.application.port.in.CreateBookUseCase;
import com.ricardo.library.application.port.out.BookRepository;
import com.ricardo.library.domain.model.*;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreateBookService implements CreateBookUseCase {

	private final BookRepository bookRepository;

	public CreateBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book create(CreateBookCommand command) {
		String id = UUID.randomUUID().toString();
		List<Author> authors = command.authors().stream().map(Author::new).toList();
		Book book = new Book(id, command.title(), new Isbn(command.isbn()), authors, new Category(command.category()), new Publication(command.publicationYear(), command.publisher()));
		return bookRepository.save(book);
	}
}