package com.personal.miniproject.service;
import com.personal.miniproject.entity.Book;

public interface BookService {
    Book getBookById(String bookId);
    Book insertBook(Book book);
    void updateBook(Book book);
    void deleteBookById(String bookId);
}
