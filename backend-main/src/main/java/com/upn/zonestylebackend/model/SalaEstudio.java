package com.upn.zonestylebackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class SalaEstudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idSala;


    @Column(nullable = false, length = 50)
    private String nombre;


    @Column(nullable = false, length = 150)
    private String direccion;


    @Column(length = 200)
    private String descripcion;


    @Column(nullable = false)
    private Integer capacidad;
}