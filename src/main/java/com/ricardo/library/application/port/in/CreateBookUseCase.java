package com.ricardo.library.application.port.in;

import com.ricardo.library.domain.model.Book;

public interface CreateBookUseCase {

	Book create(CreateBookCommand command);

	record CreateBookCommand(String title, String isbn, java.util.List<String> authors, String category, int publicationYear, String publisher) {
	}
}