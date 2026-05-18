package com.dam.userapp.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nacionalidad;
    private String nacimiento;
    private String objetivo;
    private String email;
    private boolean activo;
}