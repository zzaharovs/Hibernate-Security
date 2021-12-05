package ru.netology.daohiber.entity;

public class PersonAlreadyExistsException extends RuntimeException{

    public PersonAlreadyExistsException(String message) {
        super(message);
    }
}
