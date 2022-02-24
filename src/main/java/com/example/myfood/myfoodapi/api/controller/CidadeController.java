package com.example.myfood.myfoodapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.myfood.myfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.example.myfood.myfoodapi.domain.exception.NegocioException;
import com.example.myfood.myfoodapi.domain.model.Cidade;
import com.example.myfood.myfoodapi.domain.repository.CidadeRepository;
import com.example.myfood.myfoodapi.domain.service.CadastroCidadeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController // componete controlador rest
@RequestMapping("/cidades") // caminho do request
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidade;

	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

	@GetMapping("/{cidadeId}")
	public Cidade buscar(@PathVariable Long cidadeId) {
		return cadastroCidade.buscarOuFalhar(cidadeId);
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody @Valid Cidade cidade) {
		try {
			return cadastroCidade.salvar(cidade);

		} catch (EntidadeNaoEncontradaException e) {//mudando o codigo http
			throw new NegocioException(e.getMessage(), e);
		}
	}


	@PutMapping("/{cidadeId}")
	public Cidade atualizar(@PathVariable @Valid Long cidadeId,
			@RequestBody Cidade cidade) {
		Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);

		BeanUtils.copyProperties(cidade, cidadeAtual, "id");
		try {
			return cadastroCidade.salvar(cidadeAtual);

		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}

	}

	@DeleteMapping("/{cidadeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cidadeId) {
		cadastroCidade.excluir(cidadeId);
	}


}
