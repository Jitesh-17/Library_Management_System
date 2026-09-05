package com.jitesh.library_api.service;
import java.util.List;

import org.springframework.data.domain.Page;
import com.jitesh.library_api.dto.BorrowRecordResponse;


import com.jitesh.library_api.model.BorrowRecord;
public interface BorrowRecordService {
    BorrowRecord borrowBook(Long bookId,Long memberId);

    BorrowRecord returnBook(Long borrowId);

    List<BorrowRecord> getBorrowingHistory(Long memberId);
    List<BorrowRecord> getCurrentBorrowedBooks(Long memberId);
    Page<BorrowRecordResponse> getAllBorrowingRecords(int page, int size);
}
