package com.example.myfood.myfoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.example.myfood.myfoodapi.domain.model.Restaurante;
import com.example.myfood.myfoodapi.domain.repository.RestauranteRepository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> listar() {

        TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class);
        return query.getResultList();
    }

    @Override
    public Restaurante buscar(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Override
    @Transactional // metodos que modifiacam o bd
    public Restaurante salvar(Restaurante restaurante) {
        return manager.merge(restaurante);// adiciona e atualiza com id
    }

    @Override
    @Transactional
    public void remover(Long id) {
        Restaurante restaurante = this.buscar(id);
        if (restaurante == null)
            throw new EmptyResultDataAccessException(1);
        manager.remove(restaurante);
    }
}
