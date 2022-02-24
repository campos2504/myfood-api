package com.example.myfood.myfoodapi.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.myfood.myfoodapi.Groups;
import lombok.Data;
import lombok.EqualsAndHashCode;

//@Table(name = "tab_cozinha") relaciona com o nome da tabela dentro do bd ou cria a tabela com o nome designada
@Entity // É uma entidade dentro do modelo relacional
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//Apenas parametros explicitos
@Data//gerar getters and setter
public class Cozinha {

    
	@NotNull(groups = Groups.CozinhaId.class)
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;

}
