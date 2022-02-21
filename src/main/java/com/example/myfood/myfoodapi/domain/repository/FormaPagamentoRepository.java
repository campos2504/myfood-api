package com.example.myfood.myfoodapi.domain.repository;

import com.example.myfood.myfoodapi.domain.model.FormaPagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
    


}
