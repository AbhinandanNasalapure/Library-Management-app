package com.library.nl.library.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookNotFoundException extends RuntimeException{
    String message;
    public BookNotFoundException(String message){
        super( message);
    }

}
