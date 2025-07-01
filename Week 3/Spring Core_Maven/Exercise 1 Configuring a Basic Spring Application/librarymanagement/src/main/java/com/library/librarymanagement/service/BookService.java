package com.library.librarymanagement.service;

import com.library.librarymanagement.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        System.out.println("Service layer: Trying to add book...");
        bookRepository.saveBook();
    }
}
