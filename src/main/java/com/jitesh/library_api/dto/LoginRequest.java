package com.jitesh.library_api.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Username or email is required")
    private String identifier;

    @NotBlank(message = "password is required")
    private String password;

    // No-argument constructor
    public LoginRequest() {
    }

    // All-argument constructor
    public LoginRequest(String identifier, String password) {
        this.identifier = identifier;
        this.password = password;
    }

    // Getters
    public String getIdentifier() {
        return identifier;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}