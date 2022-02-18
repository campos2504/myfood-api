package com.example.myfood.myfoodapi.api.controller;

import java.util.List;

import com.example.myfood.myfoodapi.domain.exception.EntidadeEmUsoException;
import com.example.myfood.myfoodapi.domain.exception.EntidadeNaoEncontarda;
import com.example.myfood.myfoodapi.domain.model.Cidade;
import com.example.myfood.myfoodapi.domain.repository.CidadeRepository;
import com.example.myfood.myfoodapi.domain.service.CadastroCidadeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//componete controlador rest
@RequestMapping("/cidades")//caminho do request
public class CidadeController {

    @Autowired//injeta dependencia
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroCidadeService cadastroCidadeService;

    @GetMapping
    public List<Cidade> listar() {
        return cidadeRepository.listar();   
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
        Cidade cidade = cidadeRepository.buscar(cidadeId);

        if (cidade != null)
            return ResponseEntity.ok(cidade);

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionar(
        @RequestBody Cidade cidade) {
        try {
            cidade=cadastroCidadeService.salvar(cidade);
            return ResponseEntity.status(HttpStatus.CREATED)
            .body(cidade); 

        } catch (EntidadeNaoEncontarda e) {
            return ResponseEntity.badRequest()
            .body(e.getMessage());
        }  
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<?> atualizar(@RequestBody Cidade cidade,
     @PathVariable Long cidadeId) {

        try {
            Cidade cidadeAtual= cidadeRepository
            .buscar(cidadeId);
            if (cidadeAtual == null)
                return ResponseEntity.notFound().build();
            BeanUtils.copyProperties(cidade, cidadeAtual, "id");
            cadastroCidadeService.salvar(cidadeAtual);
            return ResponseEntity.ok(cidadeAtual);
            
        } catch (EntidadeNaoEncontarda e) {
            return ResponseEntity.badRequest()
            .body(e.getMessage());
        }

    }

    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<Cidade> remover(@PathVariable
     Long cidadeId) {
        try {
            cadastroCidadeService.excluir(cidadeId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontarda e) {
            return ResponseEntity.notFound().build();

        }catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
    
}
