package com.jitesh.library_api.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.jitesh.library_api.dto.BookPageResponse;
import com.jitesh.library_api.dto.BookRequest;
import com.jitesh.library_api.model.Book;


public interface BookService {

    BookPageResponse getAllBooks(Pageable pageable);

    Book addBook(BookRequest request);
    Book getBookById(Long id);
    Book updateBook(Long id,BookRequest request);
    void deleteBook(Long id);

    List<Book> searchBooksByTitle(String title);
    List<Book> getBooksByAuthor(String author);

}