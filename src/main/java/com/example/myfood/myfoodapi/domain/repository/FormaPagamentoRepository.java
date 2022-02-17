package com.example.myfood.myfoodapi.domain.repository;

import java.util.List;

import com.example.myfood.myfoodapi.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
    
    List<FormaPagamento> listar();
    FormaPagamento buscar(Long id);
    FormaPagamento salvar(FormaPagamento FormaPagamento);
    void remover(FormaPagamento FormaPagamento);

}
