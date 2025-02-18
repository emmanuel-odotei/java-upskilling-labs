package com.amalitech.library_system.service_stub;

import com.amalitech.library_system.entities.Book;
import com.amalitech.library_system.services.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceStub implements BookService {
    public List<Book> searchBooks(String title, String author, String genre) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Clean Code", "Robert Martin", "Programming"));
        books.add(new Book(2L, "Effective Java", "Joshua Bloch", "Programming"));
        return books.stream()
                .filter(book -> (title == null || book.getTitle().contains(title)) &&
                        (author == null || book.getAuthor().equals(author)) &&
                        (genre == null || book.getGenre().equals(genre)))
                .collect(Collectors.toList());
    }
}
