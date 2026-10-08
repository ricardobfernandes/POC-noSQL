package com.ricardo.library.application.port.in;

import com.ricardo.library.domain.model.Book;

import java.util.List;

public interface UpdateBookUseCase {

	Book update(String id, UpdateBookCommand command);

	record UpdateBookCommand(String title, String isbn, List<String> authors, String category, int publicationYear,	String publisher) {
	}
}