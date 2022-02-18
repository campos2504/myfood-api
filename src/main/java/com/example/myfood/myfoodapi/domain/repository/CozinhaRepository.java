package com.example.myfood.myfoodapi.domain.repository;

import java.util.List;

import com.example.myfood.myfoodapi.domain.model.Cozinha;

public interface CozinhaRepository {
    
    List<Cozinha> listar();
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Long id);

}
