package com.example.myfood.myfoodapi.domain.repository;

import com.example.myfood.myfoodapi.domain.model.Grupo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    


}