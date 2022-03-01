package com.example.myfood.myfoodapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException{
    private static final long serialVersionUID = 1L;

    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNaoEncontradoException(Long grupoId) {
        this(String.format("Não existe um cadastro de grupo com código %d", grupoId));
    }

}
