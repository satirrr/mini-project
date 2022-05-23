package com.personal.miniproject.service;
import com.personal.miniproject.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    Book getBookById(String bookId);
    void insertBook(Book book);
    void updateBook(Book book);
    void deleteBookById(String bookId);
}
