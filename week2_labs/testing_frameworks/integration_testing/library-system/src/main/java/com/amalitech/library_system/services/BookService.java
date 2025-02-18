package com.amalitech.library_system.services;

import com.amalitech.library_system.entities.Book;

import java.util.List;

public interface BookService {
    public List<Book> searchBooks(String title, String author, String genre);
}
