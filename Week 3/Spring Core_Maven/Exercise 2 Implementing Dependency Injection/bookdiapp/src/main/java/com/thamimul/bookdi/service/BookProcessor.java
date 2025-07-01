package com.thamimul.bookdi.service;

import com.thamimul.bookdi.repo.BookStorage;

public class BookProcessor {
    private BookStorage bookStorage;

    // Setter injection method
    public void setBookStorage(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    public void process() {
        System.out.println("Preparing to process a book...");
        bookStorage.stashBook();
    }
}
