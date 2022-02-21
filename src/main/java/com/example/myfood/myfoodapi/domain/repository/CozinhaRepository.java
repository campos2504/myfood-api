package com.example.myfood.myfoodapi.domain.repository;


import com.example.myfood.myfoodapi.domain.model.Cozinha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
    
  
}
