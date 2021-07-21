package com.springbootrest.service;

import com.springbootrest.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book getBook(String bookId);

    Book addBook(Book tempBook);

    Book updateBook(String bookId);

    void deleteBook(String bookId);
}
