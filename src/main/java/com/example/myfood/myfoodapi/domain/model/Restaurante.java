package com.example.myfood.myfoodapi.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//Apenas parametros explicitos
@Entity
public class Restaurante {
    
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name="taxa_frete", nullable = false)//mostra o nome da coluna no bd ou crai os parametros para criar o db
    private BigDecimal taxaFrete;

    @JoinColumn(name="cozinha_id", nullable = false)
    @ManyToOne
    private Cozinha cozinha;


}
