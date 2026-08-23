package com.jitesh.library_api.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
// import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.PageRequest;
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

import com.jitesh.library_api.dto.BookPageResponse;
import com.jitesh.library_api.dto.BookRequest;
import com.jitesh.library_api.model.Book;
import com.jitesh.library_api.service.BookService;
import com.jitesh.library_api.validation.PaginationValidator;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/books")//class level request mapping
public class BookController {
    
    private final BookService bookService;
    private final PaginationValidator paginationValidator;
    public BookController(BookService bookService ,PaginationValidator paginationValidator){
        this.bookService = bookService;
        this.paginationValidator = paginationValidator;
    }

    // @GetMapping("/books")
    @GetMapping
    public ResponseEntity<BookPageResponse> getAllBooks(
        @RequestParam(defaultValue = "0")int page,
        @RequestParam(defaultValue = "10")int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc")String direction){

            paginationValidator.validate(
                page,size,sortBy,direction
            );
            Pageable pageable;
            
            if(direction.equalsIgnoreCase("desc")){
                pageable = PageRequest.of(page,size,Sort.by(sortBy).descending());
            }else{
                pageable = PageRequest.of(page,size,Sort.by(sortBy).ascending());
            }

        return ResponseEntity.ok(bookService.getAllBooks(pageable));
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
