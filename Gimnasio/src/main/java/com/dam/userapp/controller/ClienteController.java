package com.dam.userapp.controller;

import com.dam.userapp.model.Cliente;
import com.dam.userapp.service.ClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(
            @RequestParam(required = false, defaultValue = "") String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            List<Cliente> resultados = clienteService.buscarPorNombre(nombre);
            return ResponseEntity.ok(resultados);
        }
        return ResponseEntity.ok(clienteService.getAllClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente nuevo = clienteService.createCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        return clienteService.getClienteById(id)
                .map(cliente -> {
                    clienteService.deleteCliente(id);
                    return ResponseEntity.noContent().<Void>build(); // 204 No Content
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 si no existe
    }

    @GetMapping("/entrenador/{entrenadorId}")
    public ResponseEntity<List<Cliente>> findByEntrenadorId(@PathVariable Long entrenadorId) {
        List<Cliente> clientes = clienteService.findByEntrenadorId(entrenadorId);
        return ResponseEntity.ok(clientes);
    }

}
