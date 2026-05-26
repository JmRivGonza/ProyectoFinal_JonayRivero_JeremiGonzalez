package com.dam.userapp.repository;

import com.dam.userapp.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {
    

    @Query("SELECT COUNT(c) FROM Clase cl JOIN cl.clientes c WHERE cl.id = :claseId")
    public Long contarClientesInscritos(@Param("claseId") Long claseId);

    

}
