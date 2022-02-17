package com.example.myfood.myfoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.example.myfood.myfoodapi.domain.model.Cozinha;
import com.example.myfood.myfoodapi.domain.repository.CozinhaRepository;

import org.springframework.stereotype.Component;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> listar() {
        
        TypedQuery<Cozinha> query= manager.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

    @Override
    public Cozinha buscar(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Override
    @Transactional//metodos que modifiacam o bd
    public Cozinha salvar(Cozinha cozinha) {
        return manager.merge(cozinha);//adiciona e atualiza com id
    }

    @Override
    @Transactional
    public void remover(Cozinha cozinha) {
        cozinha=this.buscar(cozinha.getId());
        manager.remove(cozinha);
    }
}
