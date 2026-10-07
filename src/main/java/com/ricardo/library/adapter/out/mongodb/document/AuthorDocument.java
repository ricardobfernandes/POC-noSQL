package com.ricardo.library.adapter.out.mongodb.document;

public class AuthorDocument {

    private String name;

    public AuthorDocument() {
    }

    public AuthorDocument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}