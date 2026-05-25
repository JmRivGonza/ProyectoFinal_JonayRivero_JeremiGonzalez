package com.dam.userapp.service;

import com.dam.userapp.model.Entrenamiento;
import com.dam.userapp.repository.EntrenamientoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EntrenamientoService {
    private final EntrenamientoRepository entrenamientoRepository;

    public EntrenamientoService(EntrenamientoRepository entrenamientoRepository) {
        this.entrenamientoRepository = entrenamientoRepository;
    }

    public List<Entrenamiento> findAll() {
        return entrenamientoRepository.findAll();
    }

    public Optional<Entrenamiento> findById(Long id) {
        return entrenamientoRepository.findById(id);
    }

    public Entrenamiento save(Entrenamiento entrenamiento) {
        return entrenamientoRepository.save(entrenamiento);
    }

    public Optional<Entrenamiento> update(Long id, Entrenamiento entrenamiento) {
        return entrenamientoRepository.findById(id)
                .map(existingEntrenamiento -> {
                    existingEntrenamiento.setNombre(entrenamiento.getNombre());
                    existingEntrenamiento.setDescripcion(entrenamiento.getDescripcion());
                    existingEntrenamiento.setObjetivo(entrenamiento.getObjetivo());
                    existingEntrenamiento.setDificultad(entrenamiento.getDificultad());
                    existingEntrenamiento.setDuracion(entrenamiento.getDuracion());
                    existingEntrenamiento.setHorario(entrenamiento.getHorario());
                    return entrenamientoRepository.save(existingEntrenamiento);
                });
    }

    public void delete(Long id) {
        entrenamientoRepository.deleteById(id);
    }
}