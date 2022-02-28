package com.example.myfood.myfoodapi.domain.service;

import javax.transaction.Transactional;

import com.example.myfood.myfoodapi.domain.exception.CozinhaNaoEncontradaException;
import com.example.myfood.myfoodapi.domain.exception.EntidadeEmUsoException;
import com.example.myfood.myfoodapi.domain.model.Cozinha;
import com.example.myfood.myfoodapi.domain.repository.CozinhaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    private static final String MSG_COZINHA_EM_USO = "Cozinha de codigo %d não pode ser removida, esta em uso";
    
    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);

    }

    @Transactional
    public void excluir(Long cozinhaId) {
        try {
            cozinhaRepository.deleteById(cozinhaId);
            cozinhaRepository.flush();

        } catch (DataIntegrityViolationException e) {

            throw new EntidadeEmUsoException(
                    String.format(MSG_COZINHA_EM_USO, cozinhaId));
        } catch (EmptyResultDataAccessException e) {
            throw new CozinhaNaoEncontradaException(cozinhaId);

        }

    }

    
    public Cozinha buscarOuFalhar(Long cozinhaId) {

        return cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new CozinhaNaoEncontradaException(cozinhaId));

    }

}
