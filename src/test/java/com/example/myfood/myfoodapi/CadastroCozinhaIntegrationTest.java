package com.example.myfood.myfoodapi;

import javax.validation.ConstraintViolationException;

import com.example.myfood.myfoodapi.domain.model.Cozinha;
import com.example.myfood.myfoodapi.domain.service.CadastroCozinhaService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class CadastroCozinhaIntegrationTest {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@Test
	public void testarCadastroCozinhaComSucesso() {
		// cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");

		// ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);

		// validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}

	@Test
	public void testarCadastroCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);

		ConstraintViolationException erroEsperado = Assertions.assertThrows(ConstraintViolationException.class, () -> {
			cadastroCozinha.salvar(novaCozinha);
		});

		assertThat(erroEsperado).isNotNull();
	}

}
