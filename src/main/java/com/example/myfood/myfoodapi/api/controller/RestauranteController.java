package com.example.myfood.myfoodapi.api.controller;

import java.util.List;

import com.example.myfood.myfoodapi.domain.exception.EntidadeEmUsoException;
import com.example.myfood.myfoodapi.domain.exception.EntidadeNaoEncontarda;
import com.example.myfood.myfoodapi.domain.model.Restaurante;
import com.example.myfood.myfoodapi.domain.repository.RestauranteRepository;
import com.example.myfood.myfoodapi.domain.service.CadastroRestauranteService;

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
@RequestMapping("/restaurantes")//caminho do request
public class RestauranteController {

    @Autowired//injeta dependencia
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.listar();   
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
        Restaurante restaurante = restauranteRepository.buscar(restauranteId);

        if (restaurante != null)
            return ResponseEntity.ok(restaurante);

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionar(
        @RequestBody Restaurante restaurante) {
        try {
            restaurante=cadastroRestauranteService.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED)
            .body(restaurante); 

        } catch (EntidadeNaoEncontarda e) {
            return ResponseEntity.badRequest()
            .body(e.getMessage());
        }  
    }

    @PutMapping("/{restauranteId}")
    public ResponseEntity<?> atualizar(@RequestBody Restaurante restaurante,
     @PathVariable Long restauranteId) {

        try {
            Restaurante restauranteAtual= restauranteRepository
            .buscar(restauranteId);
            if (restauranteAtual == null)
                return ResponseEntity.notFound().build();
            BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
            cadastroRestauranteService.salvar(restauranteAtual);
            return ResponseEntity.ok(restauranteAtual);
            
        } catch (EntidadeNaoEncontarda e) {
            return ResponseEntity.badRequest()
            .body(e.getMessage());
        }

    }

    @DeleteMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> remover(@PathVariable Long restauranteId) {
        try {
            cadastroRestauranteService.excluir(restauranteId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontarda e) {
            return ResponseEntity.notFound().build();

        }catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
    
}
