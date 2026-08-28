package com.jitesh.library_api.exception;

public class MemberNotFoundException extends RuntimeException {
    
    public MemberNotFoundException(String message){
        super(message);
    }
}
