package com.amalitech.library_system.service;


import com.amalitech.library_system.entities.Book;
import com.amalitech.library_system.service_stub.BookServiceStub;
import com.amalitech.library_system.services.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {
    private final BookService bookService = new BookServiceStub();
    @Test
    public void testSearchBook(){
        List<Book> books = bookService.searchBooks("Clean Code", null, null);
        assertEquals(1, books.size());
        assertEquals( "Clean Code", books.get(0).getTitle());
        assertEquals( "Robert Martin", books.get(0).getAuthor());
        assertEquals( "Programming", books.get(0).getGenre());
    }
}
