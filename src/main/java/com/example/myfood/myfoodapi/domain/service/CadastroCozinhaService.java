package com.example.myfood.myfoodapi.domain.service;

import com.example.myfood.myfoodapi.domain.exception.EntidadeEmUsoException;
import com.example.myfood.myfoodapi.domain.exception.EntidadeNaoEncontarda;
import com.example.myfood.myfoodapi.domain.model.Cozinha;
import com.example.myfood.myfoodapi.domain.repository.CozinhaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.salvar(cozinha);

    }

    public void excluir(Long id) {
        try {

            cozinhaRepository.remover(id);

        } catch (DataIntegrityViolationException e) {

            throw new EntidadeEmUsoException(
                    String.format("Cozinha de codigo %d não pode ser removida, esta em usao", id));
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontarda(
                    String.format("Cozinha de codigo %d não pode ser encontrada", id));

        }

    }

}
