package com.example.myfood.myfoodapi.domain.exception;

public class EntidadeNaoEncontarda extends RuntimeException {
    private static final long serialVersionUID = 4L;

    public  EntidadeNaoEncontarda(String message) {
        super(message);
    }
}
