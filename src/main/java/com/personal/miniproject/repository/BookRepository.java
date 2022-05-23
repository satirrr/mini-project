package com.personal.miniproject.repository;
import com.personal.miniproject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


@Transactional
public interface BookRepository extends JpaRepository<Book, String> {

    @Query(value = "SELECT * FROM mst_book", nativeQuery = true)
    Book getAllBookNative();

    @Query(value = "SELECT * FROM mst_book WHERE book_id = ?", nativeQuery = true)
    Book getBookByIdNative(String bookId);

    @Modifying
    @Query(value = "INSERT INTO mst_book(book_id, title, writer, stock) VALUES(?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertBookNative(String bookId, String title, String Writer, Integer stock);

    @Modifying
    @Query(value = "UPDATE mst_book SET title= ?2, writer= ?3, stock = ?4 WHERE book_id= ?1", nativeQuery = true)
    void updateBookByIdNative(String bookId, String title, String writer, Integer stock);

    @Modifying
    @Query(value = "DELETE FROM mst_book WHERE book_id= ?1", nativeQuery = true)
    void deleteBookByIdNative(String bookId);
}