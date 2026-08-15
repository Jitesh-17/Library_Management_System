package com.jitesh.library_api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jitesh.library_api.dto.BookRequest;
import com.jitesh.library_api.exception.BookNotFoundException;
import  com.jitesh.library_api.model.Book;
import com.jitesh.library_api.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    
    private final List<Book> books = new ArrayList<>();

    public BookServiceImpl(){
        books.add(new Book(1L,"Atomic Habits","James Clear",499.0));
        books.add(new Book(2l,"Clean Code","Robert C Martin",699.0));
    }

    @Override
    public List<Book> getAllBooks(){
        return books;
    }

    @Override
    public Book addBook(BookRequest request){
        Book book = new Book(
            (long) (books.size()+1),
            request.getTitle(),
            request.getAuthor(),
            request.getPrice()
        );
        books.add(book);

        return book;
    }

    @Override
    public Book getBookById(Long id){
        for(Book book:books){
            if(book.getId().equals(id)){
                return book;
            }
        }
        throw new BookNotFoundException("Book not found with this id"+id);
    }

    @Override
    public Book updateBook(Long id,BookRequest request){
        for(Book book:books){
            if(book.getId().equals(id)){
                book.setTitle(book.getTitle());
                book.setAuthor(book.getAuthor());
                book.setPrice(book.getPrice());

                return book;
            }
        }
        throw new BookNotFoundException("Book not found with this id"+id);
    }

    @Override
    public void deleteBook(Long id){
        for(int i=0;i<books.size();i++){
            if(books.get(i).getId().equals(id)){
                books.remove(i);
                return;
            }
        }
        throw new BookNotFoundException("Book not found with this id"+id);
    }

    @Override
    public List<Book> searchBooksByTitle(String title){
        List<Book> result = new ArrayList<>();

          for (Book book : books) {

            if (book.getTitle().toLowerCase()
                .contains(title.toLowerCase())) {

            result.add(book);
            }
            if (result.isEmpty()) {
                throw new BookNotFoundException( "No books found with title: " + title);
            }
            
        }
        return result;
    }

    @Override
    public List<Book> getBooksByAuthor(String author){
         List<Book> result = new ArrayList<>();

        for (Book book : books) {

             if (book.getAuthor().equalsIgnoreCase(author)) {
            result.add(book);
            }
        }
        if (result.isEmpty()) {
            throw new BookNotFoundException("No books found with title: " + author);
        }

    return result;
    }

}
