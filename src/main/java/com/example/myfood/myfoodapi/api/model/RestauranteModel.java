package com.example.myfood.myfoodapi.api.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteModel {


    private long id;
    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaModel cozinha;
    private boolean ativo;
}
