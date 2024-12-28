package com.next.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class BookService implements BookRepositary {
	private HashMap<Integer,Book> hmap = new HashMap<>();
	private int uniqId  = 3;
	public BookService() {
		Book b1 = new Book(1,"harryporter","harry.jpg");
		Book b2 = new Book(2,"rise","Rise.jpg");
		hmap.put(b1.getId(), b1);
		hmap.put(b2.getId(),b2);
	}
	
	@Override
	public ArrayList<Book> getBooks() {
		Collection<Book> bookCollection = hmap.values();
		ArrayList<Book> books = new ArrayList<>(bookCollection);
		return books;
	}

	@Override
	public Book getBookBYId(int bookId) {
		Book book = hmap.get(bookId);
		if(book==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return book;
	}

	@Override
	public Book addBook(Book book) {
		book.setId(uniqId);
		hmap.put(book.getId(), book);
		uniqId++;
		return book;
	}

	@Override
	public Book updateBookById(int bookId,Book book) {
		Book existingBook  = hmap.get(bookId);
		if(existingBook == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		if(book.getName() !=null) {
			existingBook.setName(book.getName());
		}
		if(book.getImageUrl() != null) {
			existingBook.setImageUrl(book.getImageUrl());
		}
		return existingBook;
	}

	@Override
	public void deleteBookById(int bookId) {
		
		Book book = hmap.get(bookId);
		if(book ==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		} else {
			hmap.remove(bookId);
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		// TODO Auto-generated method stub
		
	}
}
