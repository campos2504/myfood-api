package com.example.myfood.myfoodapi.domain.service;

import com.example.myfood.myfoodapi.domain.exception.EntidadeEmUsoException;
import com.example.myfood.myfoodapi.domain.exception.EntidadeNaoEncontarda;
import com.example.myfood.myfoodapi.domain.model.Estado;
import com.example.myfood.myfoodapi.domain.model.Cidade;
import com.example.myfood.myfoodapi.domain.repository.EstadoRepository;
import com.example.myfood.myfoodapi.domain.repository.CidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Long EstadoId = cidade.getEstado().getId();
        Estado Estado = estadoRepository.buscar(EstadoId);
        if (Estado == null)
            throw new EntidadeNaoEncontarda(String.format("Não existe cadastro de Estado com código %d", EstadoId));

        cidade.setEstado(Estado);
        return cidadeRepository.salvar(cidade);

    }

    public void excluir(Long id) {
        try {

            cidadeRepository.remover(id);

        } catch (DataIntegrityViolationException e) {

            throw new EntidadeEmUsoException(
                    String.format("Cidade de codigo %d não pode ser removida, esta em uso",
                            id));
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontarda(
                    String.format("Cidade de codigo %d não pode ser encontrada", id));

        }

    }

}
