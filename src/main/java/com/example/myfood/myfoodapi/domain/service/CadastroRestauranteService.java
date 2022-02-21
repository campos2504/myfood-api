package com.example.myfood.myfoodapi.domain.service;

import com.example.myfood.myfoodapi.domain.exception.EntidadeEmUsoException;
import com.example.myfood.myfoodapi.domain.exception.EntidadeNaoEncontarda;
import com.example.myfood.myfoodapi.domain.model.Cozinha;
import com.example.myfood.myfoodapi.domain.model.Restaurante;
import com.example.myfood.myfoodapi.domain.repository.CozinhaRepository;
import com.example.myfood.myfoodapi.domain.repository.RestauranteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new EntidadeNaoEncontarda(
                        String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));

        restaurante.setCozinha(cozinha);
        return restauranteRepository.save(restaurante);

    }

    public void excluir(Long id) {
        try {

            restauranteRepository.deleteById(id);

        } catch (DataIntegrityViolationException e) {

            throw new EntidadeEmUsoException(
                    String.format("Restaurante de codigo %d não pode ser removida, esta em uso",
                            id));
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontarda(
                    String.format("Restaurante de codigo %d não pode ser encontrada", id));

        }

    }

}
