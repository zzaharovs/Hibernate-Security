package ru.netology.daohiber.entity;

import java.util.function.Supplier;

public class ResultNotFoundException extends RuntimeException{

    public ResultNotFoundException(String message) {
        super(message);
    }

}
