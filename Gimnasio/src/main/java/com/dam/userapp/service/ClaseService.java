package com.dam.userapp.service;

import com.dam.userapp.model.Clase;
import com.dam.userapp.repository.ClaseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {
    private final ClaseRepository claseRepository;

    public ClaseService(ClaseRepository claseRepository) {
        this.claseRepository = claseRepository;
    }

    public List<Clase> getAllClases() {
        return claseRepository.findAll();
    }

    public Optional<Clase> getClaseById(Long id) {
        return claseRepository.findById(id);
    }

    public Clase createClase(Clase clase) {
        return claseRepository.save(clase);
    }

    public Long obtenerAforoActual(Long claseId) {
        return claseRepository.contarClientesInscritos(claseId);
    }
}
