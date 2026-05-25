package com.dam.userapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "entrenamientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrenamiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre; // Ej: Crossfit, Natacion, Running, Pilates, Yoga
    private String descripcion; // Descripcion del entrenamiento
    private String objetivo; // Objetivo del entrenamiento
    private String dificultad; // Principiante, Intermedio, Avanzado
    private String duracion; // Ejemplo: 30 minutos, 1 hora, 2 horas, etc.
    private String horario;  // Miercoles a las 19:00

}
