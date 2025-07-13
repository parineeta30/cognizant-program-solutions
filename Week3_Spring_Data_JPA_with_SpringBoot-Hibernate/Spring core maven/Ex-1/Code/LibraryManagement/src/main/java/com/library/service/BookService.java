package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    public void addBook(String bookName) {
        System.out.println("Adding book: " + bookName);
        BookRepository bookRepository = new BookRepository();
        bookRepository.saveBook(bookName);
    }
}
