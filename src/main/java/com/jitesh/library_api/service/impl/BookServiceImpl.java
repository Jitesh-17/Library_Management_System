package com.jitesh.library_api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jitesh.library_api.dto.BookRequest;
import com.jitesh.library_api.exception.BookNotFoundException;
import com.jitesh.library_api.model.Book;
import  com.jitesh.library_api.repository.BookRepository;
import com.jitesh.library_api.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }


    @Override
    public List<Book> getAllBooks() {
    return bookRepository.findAll();
    }

  @Override
public Book addBook(BookRequest request) {

    Book book = new Book();

    book.setTitle(request.getTitle());
    book.setAuthor(request.getAuthor());
    book.setPrice(request.getPrice());

    return bookRepository.save(book);
}

    @Override
    public Book getBookById(Long id){
        return bookRepository.findById(id)//return type Optional<T> to prevent null pointer exception
        .orElseThrow(() ->
                new BookNotFoundException("Book not found with id: " + id));
    }

   @Override
    public Book updateBook(Long id, BookRequest request) {

    Book book = bookRepository.findById(id)
            .orElseThrow(() ->
                    new BookNotFoundException(
                            "Book not found with id: " + id
                    ));

    book.setTitle(request.getTitle());
    book.setAuthor(request.getAuthor());
    book.setPrice(request.getPrice());

    return bookRepository.save(book);
    }
    @Override
    public void deleteBook(Long id) {  

    if (!bookRepository.existsById(id)) {
        throw new BookNotFoundException(
                "Book not found with id: " + id
        );
    }

        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> searchBooksByTitle(String title){
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title search cannot be empty");
        }

        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(title);

        if(books.isEmpty()){
            throw new BookNotFoundException("No books found with title: "+ title);
        }
        return books;
    }

    @Override
    public List<Book> getBooksByAuthor(String author){
        if(author == null || author.trim().isEmpty()){
            throw new IllegalArgumentException("author name cant be empty");
        }
        
         List<Book> books = bookRepository.findByAuthorContainingIgnoreCase(author);

        if(books.isEmpty()){
            throw new BookNotFoundException("No books found with title: "+ author);
        }
        return books;
    
    }

}
