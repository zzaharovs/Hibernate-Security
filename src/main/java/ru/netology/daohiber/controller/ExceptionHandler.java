package ru.netology.daohiber.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import ru.netology.daohiber.entity.PersonAlreadyExistsException;
import ru.netology.daohiber.entity.ResultNotFoundException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity<String> handleEmptyException(ResultNotFoundException ex) {

        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PersonAlreadyExistsException.class)
    public ResponseEntity<String> handleEmptyException(PersonAlreadyExistsException ex) {

        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessException(AccessDeniedException ex) {

        return new ResponseEntity<String>("Доступ запрещен", HttpStatus.FORBIDDEN);

    }

}
