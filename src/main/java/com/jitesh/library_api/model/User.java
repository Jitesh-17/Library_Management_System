package com.jitesh.library_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity 
@Table(name="users")
public class User{
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    @Column (nullable=false,unique=true)
    private String username;

    @Column (nullable=false,unique=true)
    private String email;

    @Column (nullable=false)
    private String password;

    @Column(nullable = false)
    private String role;

    public User(){
        
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
} 