package com.ricardo.library.domain.model;

import com.ricardo.library.domain.exception.DomainException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {
	//book is not only a domain but an aggregate root

	private final String id;
	private String title;
	private Isbn isbn;
	private List<Author> authors;
	private Category category;
	private Publication publication;

	public Book(String id, String title, Isbn isbn, List<Author> authors, Category category, Publication publication) {
		validateTitle(title);
		if (authors == null || authors.isEmpty()) {
			throw new DomainException("Book must have at least one author");
		}
		this.id = id;
		this.title = title.trim();
		this.isbn = isbn;
		this.authors = new ArrayList<>(authors);
		this.category = category;
		this.publication = publication;
	}

	private void validateTitle(String title) {
		if (title == null || title.isBlank()) {
			throw new DomainException("Book title cannot be empty");
		}
	}

	public void update(String title, Isbn isbn, List<Author> authors, Category category, Publication publication) {
		validateTitle(title);
		if (authors == null || authors.isEmpty()) {
			throw new DomainException("Book must have at least one author");
		}
		this.title = title.trim();
		this.isbn = isbn;
		this.authors = new ArrayList<>(authors);
		this.category = category;
		this.publication = publication;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Isbn getIsbn() {
		return isbn;
	}

	public List<Author> getAuthors() {
		return Collections.unmodifiableList(authors);
	}

	public Category getCategory() {
		return category;
	}

	public Publication getPublication() {
		return publication;
	}
}