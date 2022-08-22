package com.library.nl.library.controller;

import com.library.nl.library.entity.Book;
import com.library.nl.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/library")
public class LibraryBookController {

    private final BookService bookService;

    public LibraryBookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<Book> getAllBooks(){
            return bookService.getAllBooks();
    }

    @GetMapping("/book/{title}")
    public Book getByBookByTitle(@PathVariable("title") String title){
        return bookService.getBookByTitle(title);
    }

    @PatchMapping("/book/{title}")
    public Book updateBook(@PathVariable("title") String title, @RequestBody Book book){
        return bookService.updateBookByTitle(title, book);
    }

    @PostMapping("/book")
    public Book addNewBook(@RequestBody Book book){
        return bookService.addNewBook(book);
    }

    @DeleteMapping("/book/{title}")
    public void deleteBook(@PathVariable("title") String title){
        bookService.deleteBookByTitle(title);
    }
}
