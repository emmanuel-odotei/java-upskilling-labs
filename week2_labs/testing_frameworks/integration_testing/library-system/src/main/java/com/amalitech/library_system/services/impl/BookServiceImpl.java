package com.amalitech.library_system.services.impl;

import com.amalitech.library_system.entities.Book;
import com.amalitech.library_system.repositories.BookRepository;
import com.amalitech.library_system.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> searchBooks(String title, String author, String genre) {
        return bookRepository.findByTitleContainingOrAuthorOrGenre(title, author, genre);
    }
}
