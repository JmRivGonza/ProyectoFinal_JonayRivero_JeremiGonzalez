package com.dam.userapp.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity // Le indica a JPA que esta clase es una entidad, osea que se guardara en una
        // tabla de la base de datos.
@Table(name = "clientes")
@Data // Genera los métodos getter, setter, equals, hashCode y toString
      // automáticamente.
@NoArgsConstructor // Genera un constructor sin argumentos.
@AllArgsConstructor // Genera un constructor con todos los argumentos.
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera un valor único para el id automáticamente.
    private Long id;
    private String nombre;
    private String nacionalidad;
    private String nacimiento;
    private String objetivo;
    private String email;
    private boolean activo;

    @ManyToOne(fetch = FetchType.EAGER) // Le indica a JPA que esta clase tiene una relación con la clase Entrenador.
    @JoinColumn(name = "entrenador_id", nullable = false) // Esto crea la FK en la tabla de MySQL
    private Entrenador entrenador;

    @ManyToMany(mappedBy = "clientes")
    @jsonIgnoreProperties("clientes") // evita que al pintar la clase vuelv a pintar el cliente
    private List<Clase> clases;
}