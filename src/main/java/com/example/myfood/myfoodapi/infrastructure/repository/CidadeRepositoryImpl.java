package com.example.myfood.myfoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.example.myfood.myfoodapi.domain.model.Cidade;
import com.example.myfood.myfoodapi.domain.repository.CidadeRepository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class CidadeRepositoryImpl implements CidadeRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> listar() {
        
        TypedQuery<Cidade> query= manager.createQuery("from Cidade", Cidade.class);
        return query.getResultList();
    }

    @Override
    public Cidade buscar(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Override
    @Transactional//metodos que modifiacam o bd
    public Cidade salvar(Cidade cidade) {
        return manager.merge(cidade);//adiciona e atualiza com id
    }

    @Override
    @Transactional
    public void remover(Long id) {
        Cidade cidade=this.buscar(id);
        if (cidade == null)
            throw new EmptyResultDataAccessException(1);
        manager.remove(cidade);
    }
}
