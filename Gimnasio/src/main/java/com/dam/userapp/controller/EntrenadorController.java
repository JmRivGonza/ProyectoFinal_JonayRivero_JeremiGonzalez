package com.dam.userapp.controller;

import com.dam.userapp.model.Entrenador;
import com.dam.userapp.service.EntrenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;
    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    // GET /users → lista todos los usuarios
    @GetMapping
    public ResponseEntity<List<Entrenador>> getAll() {
        return ResponseEntity.ok(entrenadorService.findAll());    
    }

    // GET /users/{id} → obtiene un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getById(@PathVariable Long id) {
        return entrenadorService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // POST /users → crea un nuevo usuario
    @PostMapping
    public ResponseEntity<Entrenador> create(@RequestBody Entrenador entrenador) {
        Entrenador nuevo = entrenadorService.save(entrenador);
        return ResponseEntity.ok(nuevo);    
    }

    // PUT /users/{id} → actualiza un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> update(@PathVariable Long id, @RequestBody Entrenador datos) {
        return entrenadorService.update(id, datos)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /users/{id} → elimina un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entrenadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}