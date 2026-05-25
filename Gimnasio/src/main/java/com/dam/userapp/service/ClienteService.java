package com.dam.userapp.service;

import com.dam.userapp.model.Cliente;
import com.dam.userapp.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;
    
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public List<Cliente> findByEntrenadorId(Long entrenadorId){
        return clienteRepository.findByEntrenador_Id(entrenadorId);
    }
    
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }
    
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public Optional<Cliente> updateCliente(Long id, Cliente cliente) {
        return clienteRepository.findById(id).map(existing -> {
            existing.setNombre(cliente.getNombre());
            existing.setNacionalidad(cliente.getNacionalidad());
            existing.setNacimiento(cliente.getNacimiento());
            existing.setObjetivo(cliente.getObjetivo());
            existing.setEmail(cliente.getEmail());
            existing.setActivo(cliente.isActivo());
            return clienteRepository.save(existing);
        });
    }
    
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    
}
