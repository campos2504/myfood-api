package com.example.myfood.myfoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.example.myfood.myfoodapi.domain.model.FormaPagamento;
import com.example.myfood.myfoodapi.domain.repository.FormaPagamentoRepository;

import org.springframework.stereotype.Component;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> listar() {
        
        TypedQuery<FormaPagamento> query= manager.createQuery("from FormaPagamento", FormaPagamento.class);
        return query.getResultList();
    }

    @Override
    public FormaPagamento buscar(Long id) {
        return manager.find(FormaPagamento.class, id);
    }

    @Override
    @Transactional//metodos que modifiacam o bd
    public FormaPagamento salvar(FormaPagamento FormaPagamento) {
        return manager.merge(FormaPagamento);//adiciona e atualiza com id
    }

    @Override
    @Transactional
    public void remover(FormaPagamento FormaPagamento) {
        FormaPagamento=this.buscar(FormaPagamento.getId());
        manager.remove(FormaPagamento);
    }
}
