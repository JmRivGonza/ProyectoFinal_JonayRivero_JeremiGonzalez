package com.dam.userapp.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "clases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String horario;
    private Integer sala;

    @ManyToMany
    @JoinTable(
        name = "clase_cliente",
        joinColumns = @JoinColumn(name = "clase_id"),
        inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    @JsonIgnoreProperties("clases") 
    private List<Cliente> clientes;
}