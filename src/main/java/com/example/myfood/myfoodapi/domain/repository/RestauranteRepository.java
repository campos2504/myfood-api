package com.example.myfood.myfoodapi.domain.repository;


import com.example.myfood.myfoodapi.domain.model.Restaurante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{
    


}
