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

import java.util.List;
import java.util.Optional;

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
        List<Book> bookList = bookService.getAllBook();
        List<Member> memberList = memberService.getAllMember();

        Book book = bookList.stream()
                .filter(x -> x.getBookId().equals(lendingHistory.getBook().getBookId()))
                .findAny().orElse(null);

        Member member = memberList.stream()
                .filter(x -> x.getMemberId().equals(lendingHistory.getMember().getMemberId()))
                .findAny().orElse(null);

        LendingHistory lendingHistory1 = lendingHistoryRepository.findByMemberAndBook(member, book);
        if (lendingHistory1 != null){
            throw new RuntimeException();
        }
        LendingHistory lendingBook = LendingHistory.builder().book(book).member(member).build();
        if (book != null) {
            bookService.lendingBook(book.getBookId());
        }
        return lendingHistoryRepository.save(lendingBook);
    }
}
