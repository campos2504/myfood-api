package com.example.myfood.myfoodapi.domain.repository;

import java.util.List;

import com.example.myfood.myfoodapi.domain.model.Estado;

public interface EstadoRepository {
    
    List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado Estado);
    void remover(Long id);

}
