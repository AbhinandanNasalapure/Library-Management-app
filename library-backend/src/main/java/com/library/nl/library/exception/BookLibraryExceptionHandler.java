package com.library.nl.library.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookLibraryExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFoundException(Exception ex, WebRequest request){
        return new ResponseEntity<Object>("Book not found for given title", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
