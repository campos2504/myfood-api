package com.example.myfood.myfoodapi.api.controller;

import java.util.List;

import com.example.myfood.myfoodapi.domain.model.Estado;
import com.example.myfood.myfoodapi.domain.repository.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//componete controlador rest
@RequestMapping("/estados")//caminho do request
public class EstadoController {

    @Autowired//injeta dependencia
    private EstadoRepository EstadoRepository;

    @GetMapping
    public List<Estado> listar() {
        return EstadoRepository.listar();   
    }
    
    
}
