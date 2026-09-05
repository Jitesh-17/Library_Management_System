package com.jitesh.library_api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jitesh.library_api.model.Book;
import com.jitesh.library_api.model.BorrowRecord;
import com.jitesh.library_api.model.Member;

// Book
//  ↑
//  │ @ManyToOne
//  │
// BorrowRecord
//  │
//  │ @ManyToOne
//  ↓
// Member

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord,Long> {
    
    boolean existsByBookAndReturnDateIsNull(Book book);

    List<BorrowRecord> findByMember(Member member);//return all borrowrecords of that member
    List<BorrowRecord> findByMemberAndReturnDateIsNull(Member member);// return the borrowRecord of books which is currently borrowed

    Page<BorrowRecord> findAllByOrderByBorrowDateDesc(Pageable pageable);
}
