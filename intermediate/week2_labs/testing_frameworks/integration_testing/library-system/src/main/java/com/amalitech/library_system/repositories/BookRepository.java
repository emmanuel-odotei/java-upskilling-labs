package com.amalitech.library_system.repositories;

import com.amalitech.library_system.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContainingOrAuthorOrGenre(String title, String author, String genre);
}
