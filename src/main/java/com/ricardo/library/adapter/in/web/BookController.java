package com.ricardo.library.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ricardo.library.adapter.in.web.dto.BookResponse;
import com.ricardo.library.adapter.in.web.dto.CreateBookRequest;
import com.ricardo.library.adapter.in.web.dto.UpdateBookRequest;
import com.ricardo.library.adapter.in.web.mapper.BookWebMapper;
import com.ricardo.library.application.port.in.CreateBookUseCase;
import com.ricardo.library.application.port.in.DeleteBookUseCase;
import com.ricardo.library.application.port.in.FindBookUseCase;
import com.ricardo.library.application.port.in.UpdateBookUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
	private final CreateBookUseCase createBookUseCase;
	private final FindBookUseCase findBookUseCase;
	private final UpdateBookUseCase updateBookUseCase;
	private final DeleteBookUseCase deleteBookUseCase;

	public BookController(CreateBookUseCase createBookUseCase, FindBookUseCase findBookUseCase, UpdateBookUseCase updateBookUseCase, DeleteBookUseCase deleteBookUseCase) {
	    this.createBookUseCase = createBookUseCase;
	    this.findBookUseCase = findBookUseCase;
	    this.updateBookUseCase = updateBookUseCase;
	    this.deleteBookUseCase = deleteBookUseCase;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookResponse create(@Valid @RequestBody CreateBookRequest request) {
		CreateBookUseCase.CreateBookCommand command = new CreateBookUseCase.CreateBookCommand(request.title(), request.isbn(), request.authors(), request.category(), request.publicationYear(), request.publisher());
		return BookWebMapper.toResponse(createBookUseCase.create(command));
	}
	
	@GetMapping
	public java.util.List<BookResponse> findAll() {
	    return findBookUseCase.findAll().stream().map(BookWebMapper::toResponse).toList();
	}
	
	@GetMapping("/{id}")
	public BookResponse findById(@PathVariable String id) {
	    return BookWebMapper.toResponse(findBookUseCase.findById(id));
	}
	
	@GetMapping("/isbn/{isbn}")
	public BookResponse findByIsbn(@PathVariable String isbn) {
	    return BookWebMapper.toResponse(findBookUseCase.findByIsbn(isbn));
	}
	
	@PutMapping("/{id}")
	public BookResponse update(@PathVariable String id, @Valid @RequestBody UpdateBookRequest request) {
		UpdateBookUseCase.UpdateBookCommand command = new UpdateBookUseCase.UpdateBookCommand(request.title(), request.isbn(), request.authors(), request.category(), request.publicationYear(), request.publisher());
		return BookWebMapper.toResponse(updateBookUseCase.update(id, command));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
	    deleteBookUseCase.delete(id);
	}
}