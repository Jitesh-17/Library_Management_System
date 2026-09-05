package com.jitesh.library_api.exception;

public class BorrowRecordNotFoundException extends RuntimeException {

    public BorrowRecordNotFoundException(String message) {
        super(message);
    }
}