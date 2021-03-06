package com.example.myfood.myfoodapi.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Apenas parametros explicitos
@Entity
public class Restaurante {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(name = "taxa_frete", nullable = false)
  private BigDecimal taxaFrete;

  @ManyToOne
  @JoinColumn(name = "cozinha_id", nullable = false)
  private Cozinha cozinha;

  @Embedded
  private Endereco endereco;

  @Column(nullable = false)
  private boolean ativo = Boolean.TRUE;

  @CreationTimestamp
  @Column(nullable = false)
  private OffsetDateTime dataCadastro;

  @UpdateTimestamp
  @Column(nullable = false)
  private OffsetDateTime dataAtualizacao;

  @ManyToMany
  @JoinTable(name = "restaurante_forma_pagamento", joinColumns = @JoinColumn(name = "restaurante_id"), inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
  private List<FormaPagamento> formasPagamento = new ArrayList<>();

  @OneToMany(mappedBy = "restaurante")
  private List<Produto> produtos = new ArrayList<>();

  public void ativar() {
    setAtivo(true);
  }

  public void inativar() {
    setAtivo(false);
  }

  public boolean removerFormaPagamento(FormaPagamento formaPagamento) {
		return getFormasPagamento().remove(formaPagamento);
	}
	
	public boolean adicionarFormaPagamento(FormaPagamento formaPagamento) {
		return getFormasPagamento().add(formaPagamento);
	}
	

}
