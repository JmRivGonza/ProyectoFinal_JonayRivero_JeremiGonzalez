package com.dam.userapp.repository;

import com.dam.userapp.model.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByEntrenador_Id(Long entrenadorId);
}
