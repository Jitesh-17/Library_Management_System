package com.jitesh.library_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jitesh.library_api.dto.BookRequest;
import com.jitesh.library_api.model.Book;
import com.jitesh.library_api.service.BookService;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/books")//class level request mapping
public class BookController {
    
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    // @GetMapping("/books")
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    // @PostMapping("/books")
    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody BookRequest request){
        Book savedBook = bookService.addBook(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    // @GetMapping("/books/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {

        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    // @PutMapping("/books/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@Valid @RequestBody BookRequest request){

        Book updatedBook = bookService.updateBook(id, request);
        return ResponseEntity.ok(updatedBook);
    }
    
    // @DeleteMapping("/books/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){

        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // @GetMapping("/books/search")
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooksByTitle(@RequestParam String title) {
        List<Book> books = bookService.searchBooksByTitle(title);

        return ResponseEntity.ok(books);
    }

    // @GetMapping("/books/author/{author}")
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor( @PathVariable String author) {

        List<Book> books = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }
    
    
}
