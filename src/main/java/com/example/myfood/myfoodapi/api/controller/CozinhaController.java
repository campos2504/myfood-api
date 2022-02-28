package com.example.myfood.myfoodapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.myfood.myfoodapi.api.assembler.CozinhaInputDisassembler;
import com.example.myfood.myfoodapi.api.assembler.CozinhaModelAssembler;
import com.example.myfood.myfoodapi.api.model.CozinhaModel;
import com.example.myfood.myfoodapi.api.model.input.CozinhaInput;
import com.example.myfood.myfoodapi.domain.model.Cozinha;
import com.example.myfood.myfoodapi.domain.repository.CozinhaRepository;
import com.example.myfood.myfoodapi.domain.service.CadastroCozinhaService;

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
@RequestMapping("/cozinhas") // caminho do request
public class CozinhaController {
    
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;
	
	@Autowired
	private CozinhaModelAssembler cozinhaModelAssembler;
	
	@Autowired
	private CozinhaInputDisassembler cozinhaInputDisassembler;
	
	@GetMapping
	public List<CozinhaModel> listar() {
		List<Cozinha> todasCozinhas = cozinhaRepository.findAll();
		
		return cozinhaModelAssembler.toCollectionModel(todasCozinhas);
	}
	
	@GetMapping("/{cozinhaId}")
	public CozinhaModel buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);
		
		return cozinhaModelAssembler.toModel(cozinha);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CozinhaModel adicionar(@RequestBody @Valid CozinhaInput cozinhaInput) {
		Cozinha cozinha = cozinhaInputDisassembler.toDomainObject(cozinhaInput);
		cozinha = cadastroCozinha.salvar(cozinha);
		
		return cozinhaModelAssembler.toModel(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public CozinhaModel atualizar(@PathVariable Long cozinhaId,
			@RequestBody @Valid CozinhaInput cozinhaInput) {
		Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);
		cozinhaInputDisassembler.copyToDomainObject(cozinhaInput, cozinhaAtual);
		cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);
		
		return cozinhaModelAssembler.toModel(cozinhaAtual);
	}
	
	@DeleteMapping("/{cozinhaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cozinhaId) {
		cadastroCozinha.excluir(cozinhaId);
	}

 
}
