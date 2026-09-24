package com.jitesh.library_api.dto;

import java.time.LocalDate;

public class BorrowRecordResponse {

    private Long borrowId;

    private Long bookId;
    private String bookTitle;

    private Long memberId;
    private String memberName;

    private LocalDate borrowDate;
    private LocalDate returnDate;

    // No-argument constructor
    public BorrowRecordResponse() {
    }

    // All-argument constructor
    public BorrowRecordResponse(
            Long borrowId,
            Long bookId,
            String bookTitle,
            Long memberId,
            String memberName,
            LocalDate borrowDate,
            LocalDate returnDate) {

        this.borrowId = borrowId;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.memberId = memberId;
        this.memberName = memberName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters
    public Long getBorrowId() {
        return borrowId;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    // Setters
    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}