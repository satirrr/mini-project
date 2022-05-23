package com.personal.miniproject.service.impl;

import com.personal.miniproject.entity.Book;
import com.personal.miniproject.repository.BookRepository;
import com.personal.miniproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookServiceImplement implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getAllBook() {
       return bookRepository.getAllBookNative();
    }

    @Override
    public Book getBookById(String bookId) {
        return bookRepository.getBookByIdNative(bookId);
    }

    @Override
    public void insertBook(Book book) {
        String bookId = UUID.randomUUID().toString().replace("-","");
        String title = book.getTitle();
        String writer = book.getWriter();
        Integer stock = book.getStock();
        bookRepository.insertBookNative(bookId, title, writer, stock);
    }

    @Override
    public void updateBook(Book book) {
        String bookId = book.getBookId();
        String title = book.getTitle();
        String writer = book.getWriter();
        Integer stock = book.getStock();
        bookRepository.updateBookByIdNative(bookId, title, writer, stock);
    }

    @Override
    public void deleteBookById(String bookId) {
        bookRepository.deleteBookByIdNative(bookId);
    }
}
