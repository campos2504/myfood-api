package com.example.myfood.myfoodapi.domain.repository;

import java.util.List;

import com.example.myfood.myfoodapi.domain.model.Cidade;

public interface CidadeRepository {
    
    List<Cidade> listar();
    Cidade buscar(Long id);
    Cidade salvar(Cidade Cidade);
    void remover(Long id);

}
