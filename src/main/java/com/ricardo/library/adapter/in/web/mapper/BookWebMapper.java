package com.ricardo.library.adapter.in.web.mapper;

import com.ricardo.library.adapter.in.web.dto.BookResponse;
import com.ricardo.library.domain.model.Book;

public class BookWebMapper {

	public static BookResponse toResponse(Book book) {
		return new BookResponse(book.getId(), book.getTitle(), book.getIsbn().value(), book.getAuthors().stream().map(author -> author.name()).toList(), book.getCategory().name(),
				book.getPublication().year(), book.getPublication().publisher());
	}
}