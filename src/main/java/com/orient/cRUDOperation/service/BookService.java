package com.orient.cRUDOperation.service;

import com.orient.cRUDOperation.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    void addBook(Book book);
    void updateBook(Long id,Book book);
    void deleteBook(Long id);
}
