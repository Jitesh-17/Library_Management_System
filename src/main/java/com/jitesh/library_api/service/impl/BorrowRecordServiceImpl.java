package com.jitesh.library_api.service.impl;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jitesh.library_api.dto.BorrowRecordResponse;
import com.jitesh.library_api.exception.BookAlreadyBorrowedException;
import com.jitesh.library_api.exception.BookAlreadyReturnedException;
import com.jitesh.library_api.exception.BookNotFoundException;
import com.jitesh.library_api.exception.BorrowRecordNotFoundException;
import com.jitesh.library_api.exception.MemberNotFoundException;
import com.jitesh.library_api.model.Book;
import com.jitesh.library_api.model.BorrowRecord;
import com.jitesh.library_api.model.Member;
import com.jitesh.library_api.repository.BookRepository;
import com.jitesh.library_api.repository.BorrowRecordRepository;
import com.jitesh.library_api.repository.MemberRepository;
import com.jitesh.library_api.service.BorrowRecordService;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
    
    private final BorrowRecordRepository borrowRecordRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public BorrowRecordServiceImpl(BorrowRecordRepository borrowRecordRepository,BookRepository bookRepository,MemberRepository memberRepository){
        this.borrowRecordRepository = borrowRecordRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    @Override
    public BorrowRecord borrowBook(Long bookId,Long memberId){
        Book book = bookRepository.findById(bookId)
                    .orElseThrow(()->
                        new BookNotFoundException("book with Id "+ bookId +" not found"));

        Member member = memberRepository.findById(memberId)
                        .orElseThrow(()->
                        new MemberNotFoundException("Member with Id "+ memberId + " not found"));

        if(borrowRecordRepository.existsByBookAndReturnDateIsNull(book)){
            throw new BookAlreadyBorrowedException("Book with ID "+ bookId +" is already borrowed");
        }

        BorrowRecord borrowRecord = new BorrowRecord();

        borrowRecord.setBook(book);
        borrowRecord.setMember(member);
        borrowRecord.setBorrowDate(LocalDate.now());

        return borrowRecordRepository.save(borrowRecord);
    }

    @Transactional
    @Override 
    public BorrowRecord returnBook(Long borrowId){
          BorrowRecord borrowRecord = borrowRecordRepository.findById(borrowId)
            .orElseThrow(() ->
                    new BorrowRecordNotFoundException(
                            "Borrow record with ID " + borrowId + " not found"
                    ));

        if (borrowRecord.getReturnDate() != null) {
            throw new BookAlreadyReturnedException(
                "Book has already been returned"
        );
    }

        borrowRecord.setReturnDate(LocalDate.now());

        return borrowRecordRepository.save(borrowRecord);
    }

    @Override
    public List<BorrowRecord> getBorrowingHistory(Long memberId) {

        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new MemberNotFoundException(
                    "Member with ID " + memberId + " not found"
            ));

        return borrowRecordRepository.findByMember(member);
    }

    @Override
    public List<BorrowRecord> getCurrentBorrowedBooks(Long memberId) {

        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new MemberNotFoundException(
                    "Member with ID " + memberId + " not found"
            ));

        return borrowRecordRepository.findByMemberAndReturnDateIsNull(member);
    }

    @Override
    public Page<BorrowRecordResponse> getAllBorrowingRecords(int page, int size) {

    Pageable pageable = PageRequest.of(page, size);

    Page<BorrowRecord> records =
            borrowRecordRepository.findAllByOrderByBorrowDateDesc(pageable);

        return records.map(record -> new BorrowRecordResponse(
            record.getBorrowId(),
            record.getBook().getId(),
            record.getBook().getTitle(),
            record.getMember().getMemberId(),
            record.getMember().getMemberName(),
            record.getBorrowDate(),
            record.getReturnDate()
        ));
    }   

}
