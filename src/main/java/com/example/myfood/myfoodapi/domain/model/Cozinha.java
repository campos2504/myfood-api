package com.example.myfood.myfoodapi.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Table(name = "tab_cozinha") relaciona com o nome da tabela dentro do bd ou cria a tabela com o nome designada
@Entity // É uma entidade dentro do modelo relacional
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//Apenas parametros explicitos
@Data//gerar getters and setter
public class Cozinha {

    @Id
    @EqualsAndHashCode.Include//parametro explicito para equals e hashcode
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Como o id sera gerado / Identity passa a resposabilidade para o bd
    private Long id;


    @JsonProperty("titulo")
    @Column(nullable = false)
    private String nome;

}
