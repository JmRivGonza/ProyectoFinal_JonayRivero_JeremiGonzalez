package com.dam.userapp.repository;

import com.dam.userapp.model.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long> {

}