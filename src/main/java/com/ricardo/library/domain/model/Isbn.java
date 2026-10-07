package com.ricardo.library.domain.model;

import com.ricardo.library.domain.exception.DomainException;

public record Isbn(String value) {

    public Isbn {
        if (value == null || value.isBlank()) {
            throw new DomainException("ISBN cannot be empty");
        }
        String normalized = value.replace("-", "").trim();
        if (normalized.length() != 13) {
            throw new DomainException("ISBN must contain 13 digits");
        }
     // Ensures the ISBN contains only numeric digits
        if (!normalized.matches("\\d{13}")) { 
            throw new DomainException("ISBN must contain only digits");
        }
        value = normalized;
    }
}