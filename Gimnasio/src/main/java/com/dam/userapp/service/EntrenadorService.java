package com.dam.userapp.service;

import com.dam.userapp.model.Entrenador;
import com.dam.userapp.repository.EntrenadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {
    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public List<Entrenador> findAll() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> findById(Long id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador save(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Optional<Entrenador> update(Long id, Entrenador entrenador) {
        return entrenadorRepository.findById(id)
                .map(existingEntrenador -> {
                    existingEntrenador.setNombre(entrenador.getNombre());
                    existingEntrenador.setEspecialidad(entrenador.getEspecialidad());
                    return entrenadorRepository.save(existingEntrenador);
                });
    }

    public void delete(Long id) {
        entrenadorRepository.deleteById(id);
    }
}