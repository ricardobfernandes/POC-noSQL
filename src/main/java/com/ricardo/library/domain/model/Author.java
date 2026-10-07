package com.ricardo.library.domain.model;

import com.ricardo.library.domain.exception.DomainException;

public record Author(String name) {

	public Author {
		if (name == null || name.isBlank()) {
			throw new DomainException("Author name cannot be empty");
		}
		name = name.trim();
	}
}