package com.example.myfood.myfoodapi.domain.exception;


public class EntidadeEmUsoException extends RuntimeException{
    private static final long serialVersionUID = 4L;

    public EntidadeEmUsoException(String message) {
        super(message);
    }

}
