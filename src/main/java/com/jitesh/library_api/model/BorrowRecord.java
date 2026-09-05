package com.jitesh.library_api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



// BorrowRecord → Book
//        Many → One

// BorrowRecord → Member
//        Many → One

@Entity
public class BorrowRecord {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long borrowId; //primary key
  
  @ManyToOne
  @JoinColumn(name = "book_id",nullable = false)
  private Book book; //foreign key -> book(book_id)

  @ManyToOne
  @JoinColumn(name = "member_id",nullable = false)
  private Member member; //foreign -> member (member_id)

  private LocalDate borrowDate;

  private LocalDate returnDate;

  public BorrowRecord(){

  }

    public Long getBorrowId() {
        return borrowId;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getBorrowDate() {
    return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
    this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
    return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
    }
}
