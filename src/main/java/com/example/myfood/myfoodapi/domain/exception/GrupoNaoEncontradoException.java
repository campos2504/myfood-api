package com.example.myfood.myfoodapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GrupoNaoEncontradoException extends EntidadeNaoEncontradaException{
    private static final long serialVersionUID = 1L;

    public GrupoNaoEncontradoException(String message) {
        super(message);
    }

    public GrupoNaoEncontradoException(Long grupoId) {
        this(String.format("Não existe um cadastro de grupo com código %d", grupoId));
    }

}
