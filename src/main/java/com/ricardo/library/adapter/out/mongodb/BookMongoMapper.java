package com.ricardo.library.adapter.out.mongodb;

import com.ricardo.library.adapter.out.mongodb.document.*;
import com.ricardo.library.domain.model.*;

import java.util.List;

public class BookMongoMapper {

	public static BookDocument toDocument(Book book) {
		List<AuthorDocument> authors = book.getAuthors().stream().map(author -> new AuthorDocument(author.name())).toList();
		return new BookDocument(book.getId(), book.getTitle(), new IsbnDocument(book.getIsbn().value()), authors, new CategoryDocument(book.getCategory().name()), new PublicationDocument(book.getPublication().year(), book.getPublication().publisher()));
	}

	public static Book toDomain(BookDocument document) {
		List<Author> authors = document.getAuthors().stream().map(author -> new Author(author.getName())).toList();
		return new Book(document.getId(), document.getTitle(), new Isbn(document.getIsbn().getValue()), authors, new Category(document.getCategory().getName()), new Publication(document.getPublication().getYear(), document.getPublication().getPublisher()));
	}
}