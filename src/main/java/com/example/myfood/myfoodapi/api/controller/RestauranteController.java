package com.example.myfood.myfoodapi.api.controller;

import java.util.List;

import com.example.myfood.myfoodapi.domain.model.Restaurante;
import com.example.myfood.myfoodapi.domain.repository.RestauranteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//componete controlador rest
@RequestMapping("/restaurantes")//caminho do request
public class RestauranteController {

    @Autowired//injeta dependencia
    private RestauranteRepository RestauranteRepository;

    @GetMapping
    public List<Restaurante> listar() {
        return RestauranteRepository.listar();   
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
        Restaurante restaurante = RestauranteRepository.buscar(restauranteId);

        if (restaurante != null)
            return ResponseEntity.ok(restaurante);

        return ResponseEntity.notFound().build();
    }
    
    
}
