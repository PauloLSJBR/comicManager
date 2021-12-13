package org.zup.paulo.comicmanager.exceptions.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zup.paulo.comicmanager.exceptions.ComicNotFoundException;
import org.zup.paulo.comicmanager.exceptions.ExemplaryNotFoundException;
import org.zup.paulo.comicmanager.exceptions.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerUserException(UserNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404l);
        error.setTitle("User exception.");
        error.setUrl("http://erros.teste.com/404");
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ComicNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerComicException(ComicNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404l);
        error.setTitle("Comic exception.");
        error.setUrl("http://erros.teste.com/404");
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ExemplaryNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerExemplaryException(ExemplaryNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404l);
        error.setTitle("Comic exception.");
        error.setUrl("http://erros.teste.com/404");
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
