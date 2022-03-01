package com.example.myfood.myfoodapi.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.myfood.myfoodapi.domain.model.Restaurante;

import org.springframework.stereotype.Repository;


@Repository
public interface RestauranteRepositoryQueries {


    public List<Restaurante> find(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
}
