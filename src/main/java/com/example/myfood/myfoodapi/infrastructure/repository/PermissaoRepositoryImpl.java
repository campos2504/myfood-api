package com.example.myfood.myfoodapi.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.example.myfood.myfoodapi.domain.model.Permissao;
import com.example.myfood.myfoodapi.domain.repository.PermissaoRepository;

import org.springframework.stereotype.Component;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissao> listar() {
        
        TypedQuery<Permissao> query= manager.createQuery("from Permissao", Permissao.class);
        return query.getResultList();
    }

    @Override
    public Permissao buscar(Long id) {
        return manager.find(Permissao.class, id);
    }

    @Override
    @Transactional//metodos que modifiacam o bd
    public Permissao salvar(Permissao Permissao) {
        return manager.merge(Permissao);//adiciona e atualiza com id
    }

    @Override
    @Transactional
    public void remover(Permissao Permissao) {
        Permissao=this.buscar(Permissao.getId());
        manager.remove(Permissao);
    }
}
