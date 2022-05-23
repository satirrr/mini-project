package com.personal.miniproject.controller;

import com.personal.miniproject.controller.pathURL.PathURL;
import com.personal.miniproject.entity.Book;
import com.personal.miniproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PathURL.BOOK)
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    public Book getAllBook(){
        return bookService.getAllBook();
    }

    @GetMapping
    public Book getBookById(@RequestParam String bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public void insertBook(@RequestBody Book book){
        bookService.insertBook(book);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @DeleteMapping
    public void deleteBookById(@RequestParam String bookId){
        bookService.deleteBookById(bookId);
    }
}
