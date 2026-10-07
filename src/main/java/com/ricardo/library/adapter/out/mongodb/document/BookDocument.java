package com.ricardo.library.adapter.out.mongodb.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "books")
public class BookDocument {

    @Id
    private String id;
    private String title;
    private IsbnDocument isbn;
    private List<AuthorDocument> authors;
    private CategoryDocument category;
    private PublicationDocument publication;

    public BookDocument() {
    }

    public BookDocument(
            String id,
            String title,
            IsbnDocument isbn,
            List<AuthorDocument> authors,
            CategoryDocument category,
            PublicationDocument publication
    ) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.category = category;
        this.publication = publication;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public IsbnDocument getIsbn() {
        return isbn;
    }

    public List<AuthorDocument> getAuthors() {
        return authors;
    }

    public CategoryDocument getCategory() {
        return category;
    }

    public PublicationDocument getPublication() {
        return publication;
    }
}