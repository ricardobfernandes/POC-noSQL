package com.ricardo.library.domain.model;

import com.ricardo.library.domain.exception.DomainException;

public record Publication(int year, String publisher) {

	public Publication {

		if (year < 1000 || year > 2100) {
			throw new DomainException("Publication year is invalid");
		}
		if (publisher == null || publisher.isBlank()) {
			throw new DomainException("Publisher cannot be empty");
		}
		publisher = publisher.trim();
	}
}