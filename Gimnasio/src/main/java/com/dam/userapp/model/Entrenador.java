package com.dam.userapp.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;


@Entity // Le indica a JPA que esta clase es una entidad, osea que se guardara en una tabla de la base de datos.
@Table(name = "entrenadores") // Esto crea la tabla de MySQL llamada entrenadores.
@Data // Genera los métodos getter, setter, equals, hashCode y toString automáticamente.
@NoArgsConstructor // Genera un constructor sin argumentos.
@AllArgsConstructor // Genera un constructor con todos los argumentos.
public class Entrenador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera un valor único para el id automáticamente.
    private Long id;
    private String nombre;
    private String especialidad; // Ej: Crossfit, Natacion, Running, Pilates, Yoga

    @OneToMany(mappedBy = "entrenador",cascade = CascadeType.ALL)
    @JsonIgnore // Evita el bucle infinito de JSON.
    @ToString.Exclude // Evita el bucle infinito de ToString.
    private List<Cliente> clientes;
}