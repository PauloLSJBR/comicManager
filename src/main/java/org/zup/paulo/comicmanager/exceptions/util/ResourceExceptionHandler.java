package org.zup.paulo.comicmanager.exceptions.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        error.setMessage(e.getMessage());
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
        error.setMessage(e.getMessage());
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
        error.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handlerExemplaryException(MethodArgumentNotValidException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(400l);
        error.setTitle("Validation exception.");
        error.setUrl("http://erros.teste.com/400");
        error.setTimestamp(System.currentTimeMillis());
        error.setMessage(e. getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

