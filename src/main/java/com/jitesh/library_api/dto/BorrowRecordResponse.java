package com.jitesh.library_api.dto;

import java.time.LocalDate;



import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class BorrowRecordResponse {
    
    private Long borrowId;

    private Long bookId;
    private String bookTitle;

    private Long memberId;
    private String memberName;

    private LocalDate borrowDate;
    private LocalDate returnDate;

}
