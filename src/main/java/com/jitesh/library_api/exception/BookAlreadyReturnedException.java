package com.jitesh.library_api.exception;

public class BookAlreadyReturnedException extends RuntimeException {

    public BookAlreadyReturnedException(String message) {
        super(message);
    }
}