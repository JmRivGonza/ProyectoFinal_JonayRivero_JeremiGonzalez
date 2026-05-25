package com.dam.userapp.controller;

import com.dam.userapp.model.Entrenamiento;
import com.dam.userapp.service.EntrenamientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/entrenamientos")
public class EntrenamientoController {

    private final EntrenamientoService entrenamientoService;

    public EntrenamientoController(EntrenamientoService entrenamientoService) {
        this.entrenamientoService = entrenamientoService;
    }

    @GetMapping
    public List<Entrenamiento> getAll() {
        return entrenamientoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenamiento> getById(@PathVariable Long id) {
        return entrenamientoService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrenamiento create(@RequestBody Entrenamiento entrenamiento) {
        return entrenamientoService.save(entrenamiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenamiento> update(@PathVariable Long id, @RequestBody Entrenamiento datos) {
        return entrenamientoService.update(id, datos)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entrenamientoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}