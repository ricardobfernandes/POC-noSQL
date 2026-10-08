package com.ricardo.library.application.service;

import com.ricardo.library.application.port.in.DeleteBookUseCase;
import com.ricardo.library.application.port.out.BookRepository;
import com.ricardo.library.domain.exception.ResourceNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class DeleteBookService implements DeleteBookUseCase {
	private final BookRepository bookRepository;

	public DeleteBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void delete(String id) {
		if (bookRepository.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Book not found: " + id);
		}
		bookRepository.deleteById(id);
	}
}