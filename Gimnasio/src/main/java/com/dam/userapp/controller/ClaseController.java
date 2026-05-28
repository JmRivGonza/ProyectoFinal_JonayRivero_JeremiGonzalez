package com.dam.userapp.controller;

import com.dam.userapp.model.Clase;
import com.dam.userapp.service.ClaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clases")
public class ClaseController {

    private final ClaseService claseService;

    public ClaseController(ClaseService claseService) {
        this.claseService = claseService;
    }

 

    @GetMapping
    public ResponseEntity<List<Clase>> getAllClases() {
        return ResponseEntity.ok(claseService.getAllClases());
    }

    @PostMapping
    public ResponseEntity<Clase> createClase(@RequestBody Clase clase) {
        Clase nuevaClase = claseService.createClase(clase);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaClase);
    }

    @GetMapping("/{id}/aforo")
    public ResponseEntity<Long> getAforo(@PathVariable Long id) {
        Long aforo = claseService.obtenerAforoActual(id);
        return ResponseEntity.ok(aforo);
    }
}