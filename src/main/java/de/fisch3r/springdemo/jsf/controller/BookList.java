package de.fisch3r.springdemo.jsf.controller;

import java.util.ArrayList;
import java.util.List;

import de.fisch3r.springdemo.jsf.domain.Book;

public class BookList {
	
	private List<Book> bookList = new ArrayList<Book>();

	public void add(Book book) {
		bookList.add(book);
	}

	public List<Book> getAll() {
		return bookList;
	}

}
