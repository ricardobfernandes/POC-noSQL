package com.ricardo.library.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UpdateBookRequest(@NotBlank String title, @NotBlank String isbn, @NotEmpty List<@NotBlank String> authors, @NotBlank String category, @NotNull Integer publicationYear, @NotBlank String publisher) {
}