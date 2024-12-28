package com.next.demo;

import java.util.ArrayList;

public interface BookRepositary {
	public  ArrayList<Book> getBooks();
	public Book getBookBYId(int bookId);
	public Book addBook(Book book);
	public Book updateBookById(int bookId,Book book);
	public void  deleteBookById(int booId);

}