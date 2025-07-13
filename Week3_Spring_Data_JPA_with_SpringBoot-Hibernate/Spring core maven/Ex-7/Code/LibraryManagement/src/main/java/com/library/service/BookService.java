package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private String category;

    // Constructor injection
    public BookService(String category) {
        this.category = category;
        System.out.println("Constructor Injected category: " + category);
    }

    // Setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        System.out.println("Adding book in category [" + category + "]: " + title);
        bookRepository.saveBook(title);
    }
}
