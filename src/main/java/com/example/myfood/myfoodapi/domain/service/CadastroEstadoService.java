package com.example.myfood.myfoodapi.domain.service;

import com.example.myfood.myfoodapi.domain.exception.EntidadeEmUsoException;
import com.example.myfood.myfoodapi.domain.exception.EntidadeNaoEncontarda;
import com.example.myfood.myfoodapi.domain.model.Estado;
import com.example.myfood.myfoodapi.domain.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado Estado) {
        return estadoRepository.salvar(Estado);
    }

    public void excluir(Long id) {
        try {

            estadoRepository.remover(id);

        } catch (DataIntegrityViolationException e) {

            throw new EntidadeEmUsoException(
                    String.format("Estado de codigo %d não pode ser removida, esta em usao", id));
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontarda(
                    String.format("Estado de codigo %d não pode ser encontrada", id));

        }

    }

}
