package com.jitesh.library_api.dto;

import java.util.List;

import com.jitesh.library_api.model.Book;

public class BookPageResponse {

    private List<Book> books;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

    public BookPageResponse(
            List<Book> books,
            int page,
            int size,
            long totalElements,
            int totalPages) {

        this.books = books;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }
}