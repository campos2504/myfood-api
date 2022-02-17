package com.example.myfood.myfoodapi.domain.repository;

import java.util.List;

import com.example.myfood.myfoodapi.domain.model.Restaurante;

public interface RestauranteRepository {
    
    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante Restaurante);
    void remover(Restaurante Restaurante);

}
