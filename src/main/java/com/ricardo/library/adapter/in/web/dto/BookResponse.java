package com.ricardo.library.adapter.in.web.dto;

import java.util.List;

public record BookResponse(String id, String title, String isbn, List<String> authors, String category, int publicationYear, String publisher) {
}