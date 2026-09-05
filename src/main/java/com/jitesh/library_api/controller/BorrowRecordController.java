package com.jitesh.library_api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jitesh.library_api.dto.BorrowRecordResponse;
import com.jitesh.library_api.model.BorrowRecord;
import com.jitesh.library_api.service.BorrowRecordService;

@RestController
@RequestMapping("/borrow")
public class BorrowRecordController {
    private final BorrowRecordService borrowRecordService;

    public BorrowRecordController(BorrowRecordService borrowRecordService){
        this.borrowRecordService = borrowRecordService;
    }

    @PostMapping
    public ResponseEntity<BorrowRecord> borrowBook(
            @RequestParam Long bookId,
            @RequestParam Long memberId) {

        BorrowRecord borrowRecord =
                borrowRecordService.borrowBook(bookId, memberId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(borrowRecord);
    }

    @PutMapping("/{borrowId}/return")
    public ResponseEntity<BorrowRecord> returnBook(
            @PathVariable Long borrowId) {

        BorrowRecord borrowRecord =
                borrowRecordService.returnBook(borrowId);

        return ResponseEntity.ok(borrowRecord);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<BorrowRecord>> getBorrowingHistory(@PathVariable Long memberId){

        return ResponseEntity.ok(borrowRecordService.getBorrowingHistory(memberId));
    }

    @GetMapping("/member/{memberId}/current")
        public ResponseEntity<List<BorrowRecord>> getCurrentBorrowedBooks(
                    @PathVariable Long memberId) {

        return ResponseEntity.ok(
            borrowRecordService.getCurrentBorrowedBooks(memberId)
        );
    }
    
    @GetMapping
    public ResponseEntity<Page<BorrowRecordResponse>> getAllBorrowingRecords(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(
            borrowRecordService.getAllBorrowingRecords(page, size)
        );
    }
    
}
