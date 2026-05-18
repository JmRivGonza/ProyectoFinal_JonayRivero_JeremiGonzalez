package com.dam.userapp.controller;

import com.dam.userapp.model.Entrenador;
import com.dam.userapp.service.EntrenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/entrenadores")
public class EntrenadorController {

    private final EntrenadorService libroService;

    public EntrenadorController(EntrenadorService libroService) {
        this.libroService = libroService;
    }

    // GET /users → lista todos los usuarios
    @GetMapping
    public List<Entrenador> getAll() {
        return libroService.findAll();
    }

    // GET /users/{id} → obtiene un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getById(@PathVariable Long id) {
        return libroService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // POST /users → crea un nuevo usuario
    @PostMapping
    public Entrenador create(@RequestBody Entrenador libro) {
        return libroService.save(libro);
    }

    // PUT /users/{id} → actualiza un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> update(@PathVariable Long id, @RequestBody Entrenador datos) {
        return libroService.update(id, datos)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /users/{id} → elimina un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}