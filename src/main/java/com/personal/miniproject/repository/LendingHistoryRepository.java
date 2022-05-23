package com.personal.miniproject.repository;

import com.personal.miniproject.entity.Book;
import com.personal.miniproject.entity.LendingHistory;
import com.personal.miniproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingHistoryRepository extends JpaRepository<LendingHistory, String> {
    LendingHistory findByMemberAndBook(Member member, Book book);
}
