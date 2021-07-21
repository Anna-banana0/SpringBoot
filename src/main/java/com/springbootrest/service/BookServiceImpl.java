package com.springbootrest.service;

import com.springbootrest.bookstorerepository.BookRepository;
import com.springbootrest.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    // List<Book> bookList = new ArrayList<>();

    @Autowired
    private BookRepository repoBook;

    public BookServiceImpl() {


//        bookList.add(new Book("HP1","HP & the philosopher stone","J. K. Rowling"));
//        bookList.add(new Book("HP2","HP & the chamber of secrets","J. K. Rowling"));
    }

    @Override
    public List<Book> getBooks() {
        return repoBook.findAll();
    }

    @Override
    public Book getBook(String bookId) {
//       for(Book b1 : bookList){
//           if(b1.getBookId().equals(bookId))
//               return b1;
//               }
        return repoBook.getById(bookId);
    }

    @Override
    public Book addBook(Book tempBook) {
//        bookList.add(tempBook);
        repoBook.save(tempBook);
        return tempBook;
    }

    @Override
    public Book updateBook(String bookId) {
//        int position=0;
//        for(Book b1:bookList){
//            if(b1.getBookId().equals(bookId)){
//                position = bookList.indexOf(b1);
//                bookList.set(position,tempBook);
//            }
//        }
        Book bk = repoBook.getById(bookId);
        repoBook.save(bk);
        return bk;
    }

    @Override
    public void deleteBook(String bookId) {
//        int position=0;
//        for(Book b1:bookList){
//            if(b1.getBookId().equals(bookId)){
//                position = bookList.indexOf(b1);
//                bookList.remove(position);
//            }
//        }
        Book bk = repoBook.getById(bookId);
        repoBook.save(bk);

    }


}
