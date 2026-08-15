package com.jitesh.library_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class BookRequest{

    @NotBlank(message= "Title is required")
    private String title;

    @NotBlank(message="Author is required")
    private String author;

    @Positive(message="price must be greater than 0")
    private Double price;

    public BookRequest(){

    }
    public BookRequest(String title,String author,Double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
     public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}