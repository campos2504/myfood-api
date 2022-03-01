package com.example.myfood.myfoodapi.domain.repository;

import com.example.myfood.myfoodapi.domain.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}