package com.example.myfood.myfoodapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntidadeEmUsoException extends RuntimeException{
    private static final long serialVersionUID = 4L;

    public EntidadeEmUsoException(String message) {
        super(message);
    }

}
