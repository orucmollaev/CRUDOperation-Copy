package com.orient.cRUDOperation.controller;

import com.orient.cRUDOperation.model.Book;
import com.orient.cRUDOperation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    @Autowired
    @Qualifier("bookService")
    BookService bookService;

    @GetMapping(value = "/")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping(value = "/")
    public void addCinema(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping(value = "/{id}")
    public void updateCinema(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Long id) {
            bookService.deleteBook(id);
    }

}
