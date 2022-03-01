package com.example.myfood.myfoodapi.domain.repository;



import com.example.myfood.myfoodapi.domain.model.Permissao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

}
