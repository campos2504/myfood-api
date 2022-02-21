package com.example.myfood.myfoodapi.domain.repository;

import com.example.myfood.myfoodapi.domain.model.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    

}
