package com.example.myfood.myfoodapi.domain.repository;

import java.util.List;

import com.example.myfood.myfoodapi.domain.model.Permissao;

public interface PermissaoRepository {
    
    List<Permissao> listar();
    Permissao buscar(Long id);
    Permissao salvar(Permissao Permissao);
    void remover(Permissao Permissao);

}
