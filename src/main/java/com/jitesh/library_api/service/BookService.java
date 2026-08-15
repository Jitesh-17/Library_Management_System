package com.jitesh.library_api.service;

import java.util.List;

import com.jitesh.library_api.dto.BookRequest;
import com.jitesh.library_api.model.Book;

public interface BookService {

    List<Book> getAllBooks();

    Book addBook(BookRequest request);
    Book getBookById(Long id);
    Book updateBook(Long id,BookRequest request);
    void deleteBook(Long id);

    List<Book> searchBooksByTitle(String title);
    List<Book> getBooksByAuthor(String author);

}