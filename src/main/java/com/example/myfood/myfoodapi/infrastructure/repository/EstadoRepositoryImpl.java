package com.example.myfood.myfoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.example.myfood.myfoodapi.domain.model.Estado;
import com.example.myfood.myfoodapi.domain.repository.EstadoRepository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listar() {
        
        TypedQuery<Estado> query= manager.createQuery("from Estado", Estado.class);
        return query.getResultList();
    }

    @Override
    public Estado buscar(Long id) {
        return manager.find(Estado.class, id);
    }

    @Override
    @Transactional//metodos que modifiacam o bd
    public Estado salvar(Estado estado) {
        return manager.merge(estado);//adiciona e atualiza com id
    }

    @Override
    @Transactional
    public void remover(Long id) {
        Estado estado=this.buscar(id);
        if (estado == null)
            throw new EmptyResultDataAccessException(1);
        manager.remove(estado);
    }
}
