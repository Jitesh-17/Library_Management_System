package com.jitesh.library_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitesh.library_api.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findByTitleContainingIgnoreCase(String title);
    public List<Book> findByAuthorContainingIgnoreCase(String author);
}
