package com.ricardo.library.adapter.out.mongodb.document;

public class PublicationDocument {

    private int year;
    private String publisher;

    public PublicationDocument() {
    }

    public PublicationDocument(int year, String publisher) {
        this.year = year;
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }
}