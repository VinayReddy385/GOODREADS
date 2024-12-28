package com.next.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	BookService bookService = new BookService();
	@GetMapping("/books")
	public ArrayList<Book> getBooks() {
		return bookService.getBooks();
	}
	
	@GetMapping("/books/{bookId}") 
	public Book getBookById(@PathVariable("bookId") int bookId) {
		return bookService.getBookBYId(bookId);
	}	
	
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@PathVariable("bookId") int bookId,@RequestBody Book book) {
		return bookService.updateBookById(bookId, book);
	}
	
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBookById(bookId);
	}
}
