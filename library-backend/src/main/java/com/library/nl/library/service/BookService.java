package com.library.nl.library.service;

import com.library.nl.library.entity.*;
import com.library.nl.library.exception.BookNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final ChapterRepository chapterRepository;

    public BookService(BookRepository bookRepository, ChapterRepository chapterRepository){
        this.bookRepository = bookRepository;
        this.chapterRepository = chapterRepository;
    }

    public List<Book> getAllBooks(){
       return bookRepository.findAll();
    }

    public Book getBookByTitle(String title){

        Optional<Book> optionalBook = bookRepository.findByTitle(title);
        if(optionalBook.isEmpty()){
            throw new BookNotFoundException("not found");
        }else{
            return optionalBook.get();
        }
    }

    public Book updateBookByTitle(String title, Book book){
        Book existingBook = getBookByTitle(title);
        existingBook.setAuthor(book.author);

        existingBook.setChapters(book.getChapters());
        existingBook.setEdition(book.edition);
        existingBook.setIsbn(book.isbn);
        existingBook.setPublisher(book.publisher);
        existingBook.setPublishingDate(book.publishingDate);

        return bookRepository.save(existingBook);
    }

    public Book addNewBook(Book bookToBeAdded){

        Book newBook = new Book();
        newBook.setTitle(bookToBeAdded.getTitle());
        newBook.setAuthor(bookToBeAdded.getAuthor());
        newBook.setPublisher((bookToBeAdded.getPublisher()));
        newBook.setIsbn(bookToBeAdded.getIsbn());
        newBook.setPublishingDate(bookToBeAdded.getPublishingDate());
        newBook.setChapters(bookToBeAdded.getChapters());
        newBook.setEdition(bookToBeAdded.getEdition());
        bookToBeAdded.getChapters().forEach(ch->ch.setBook(newBook));
        return bookRepository.save(newBook);
    }

    public void deleteBookByTitle(String title){
        bookRepository.deleteByTitle(title);
    }
}
