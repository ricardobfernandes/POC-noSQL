package com.ricardo.library.adapter.in.web;

import com.ricardo.library.domain.exception.DomainException;
import com.ricardo.library.domain.exception.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(404, exception.getMessage(), LocalDateTime.now()));
	}

	@ExceptionHandler(DomainException.class)
	public ResponseEntity<ApiError> handleDomain(DomainException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(400, exception.getMessage(), LocalDateTime.now()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException exception) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(400, "Invalid request", LocalDateTime.now()));
	}
	public record ApiError(int status, String message, LocalDateTime timestamp) {
	}
}