package com.dam.userapp.service;

import com.dam.userapp.model.Clase;
import com.dam.userapp.repository.ClaseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.dam.userapp.repository.ClienteRepository;

@Service
public class ClaseService {
    private final ClaseRepository claseRepository;
    private final ClienteRepository clienteRepository;

    public ClaseService(ClaseRepository claseRepository, ClienteRepository clienteRepository) {
        this.claseRepository = claseRepository;
        this.clienteRepository = clienteRepository;
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

    public void deleteClase(Long id) {
        claseRepository.deleteById(id);
    }

    public Optional<Clase> addCliente(Long claseId, Long clienteId) {
        return claseRepository.findById(claseId).map(clase -> {
            clienteRepository.findById(clienteId).ifPresent(cliente -> {
                if (!clase.getClientes().contains(cliente)) {
                    clase.getClientes().add(cliente);
                }
            });
            return claseRepository.save(clase);
        });
    }
}
