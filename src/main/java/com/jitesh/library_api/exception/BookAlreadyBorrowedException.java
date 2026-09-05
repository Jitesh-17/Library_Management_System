package com.jitesh.library_api.exception;

public class BookAlreadyBorrowedException extends RuntimeException {

    public BookAlreadyBorrowedException(String message) {
        super(message);
    }
}