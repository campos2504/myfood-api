package com.example.myfood.myfoodapi.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.example.myfood.myfoodapi.Groups;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//Apenas parametros explicitos
@Entity
public class Cidade {
    
    @EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@JsonIgnoreProperties(value="nome", allowGetters = true)
	@Valid
	@ConvertGroup(from = Default.class, to = Groups.EstadoId.class)
	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;
   


}
