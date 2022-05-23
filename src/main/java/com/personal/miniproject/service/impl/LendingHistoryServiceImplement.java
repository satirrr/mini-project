package com.personal.miniproject.service.impl;

import com.personal.miniproject.entity.Book;
import com.personal.miniproject.entity.LendingHistory;
import com.personal.miniproject.entity.Member;
import com.personal.miniproject.repository.LendingHistoryRepository;
import com.personal.miniproject.service.BookService;
import com.personal.miniproject.service.LendingHistoryService;
import com.personal.miniproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LendingHistoryServiceImplement implements LendingHistoryService {
    @Autowired
    LendingHistoryRepository lendingHistoryRepository;
    @Autowired
    BookService bookService;
    @Autowired
    MemberService memberService;

    @Override
    public LendingHistory insertLendingHistory(LendingHistory lendingHistory) {
        Book book = bookService.getBookById(lendingHistory.getBook().getBookId());
        Member member = memberService.getMemberById(lendingHistory.getMember().getMemberId());
        LendingHistory lendingHistory1 = lendingHistoryRepository.findByMemberAndBook(member, book);
        if (lendingHistory1 != null){
            throw new RuntimeException();
        }
        LendingHistory lendingBook = LendingHistory.builder().book(book).member(member).build();
        bookService.lendingBook(book.getBookId());
        return lendingHistoryRepository.save(lendingBook);
    }
}
