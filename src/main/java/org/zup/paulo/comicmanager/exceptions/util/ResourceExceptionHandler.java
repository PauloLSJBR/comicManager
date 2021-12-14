package org.zup.paulo.comicmanager.exceptions.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zup.paulo.comicmanager.exceptions.ComicNotFoundException;
import org.zup.paulo.comicmanager.exceptions.EmailOrCpfJaCadastradoExcetion;
import org.zup.paulo.comicmanager.exceptions.ExemplaryNotFoundException;
import org.zup.paulo.comicmanager.exceptions.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @ExceptionHandler(EmailOrCpfJaCadastradoExcetion.class)
    public ResponseEntity<ErrorDetails> handlerExemplaryException(EmailOrCpfJaCadastradoExcetion e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(422l);
        error.setTitle("Exite Mail ou CPF ja cadastrado");
        error.setUrl("http://erros.teste.com/404");
        error.setTimestamp(System.currentTimeMillis());
        error.setMessage(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handlerExemplaryException(MethodArgumentNotValidException e, HttpServletRequest request) {
//        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(400l);
        error.setTitle("Validation exception.");
        error.setUrl("http://erros.teste.com/400");
        error.setTimestamp(System.currentTimeMillis());

        String msnErro = "";
        for(ObjectError err : e.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) err).getField();
            String errorMessage = err.getDefaultMessage();
            msnErro = errorMessage + ", " + msnErro;
            System.out.println("Nome = "+fieldName+" msnErr = " + errorMessage);
        }
        error.setMessage(msnErro);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}

