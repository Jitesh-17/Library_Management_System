package com.jitesh.library_api.dto;

public class UserResponse {

    private Long id;

    private String userName;

    private String email;

    private String role;

    // No-argument constructor
    public UserResponse() {
    }

    // All-argument constructor
    public UserResponse(Long id, String userName, String email, String role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}