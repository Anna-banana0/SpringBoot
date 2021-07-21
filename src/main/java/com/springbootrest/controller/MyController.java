package com.springbootrest.controller;

import com.springbootrest.entity.Book;
import com.springbootrest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private BookService bs;

    @GetMapping("/home")
    public String home(){
        return "Welcome to the Bookstore!";
    }

    //Get all books
    @GetMapping("/books")
    public List<Book> getBooks(){

        return this.bs.getBooks();
    }

    //Get book by bookId
    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable String bookId){

        return this.bs.getBook(bookId);
    }

    //add a new book
    @PostMapping("/books")
    public Book addBook(@RequestBody Book tempBook){

        return this.bs.addBook(tempBook);
    }

    //update book by BookId
    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable String bookId ,@RequestBody Book tempBook){
        return this.bs.updateBook(bookId);
    }

    //delete book
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable String bookId){
        try{
            this.bs.deleteBook(bookId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
