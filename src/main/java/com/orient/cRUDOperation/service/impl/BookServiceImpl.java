package com.orient.cRUDOperation.service.impl;

import com.orient.cRUDOperation.model.Book;
import com.orient.cRUDOperation.repository.BookRepository;
import com.orient.cRUDOperation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        Book book=null;
        try{
            book=bookRepository.findById(id).get();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return book;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long id, Book book) {
        Book oldBook=bookRepository.findById(id).get();
        oldBook.setName(book.getName());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setPublishYear(book.getPublishYear());
        bookRepository.save(oldBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book book=findById(id);
        if (book!=null){
            bookRepository.delete(book);
        }
    }
}
