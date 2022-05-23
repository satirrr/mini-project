package com.personal.miniproject.service;
import com.personal.miniproject.entity.Book;

public interface BookService {
    Book getBookById(String bookId);
    void insertBook(Book book);
}
