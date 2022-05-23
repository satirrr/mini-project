package com.personal.miniproject.repository;
import com.personal.miniproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;


@Transactional
public interface BookRepository extends JpaRepository<Book, String> {
    @Query(value = "SELECT * FROM mst_book WHERE book_id = ?", nativeQuery = true)
    Book getBookByIdNative(String bookId);

    @Modifying
    @Query(value = "INSERT INTO mst_book(book_id, title, writer, stock) VALUES(?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertBookNative(String bookId, String title, String Writer, Integer stock);

}