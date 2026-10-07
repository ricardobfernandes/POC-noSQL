package com.ricardo.library.domain.model;

import com.ricardo.library.domain.exception.DomainException;

public record Category(String name) {

	public Category {
		if (name == null || name.isBlank()) {
			throw new DomainException("Category name cannot be empty");
		}
		name = name.trim();
	}
}