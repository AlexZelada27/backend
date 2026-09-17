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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCliente;


    @Column(nullable = false, length = 100)
    private String nombre;


    @Column(nullable = false, length = 15)
    private String telefono;


    @Column(nullable = false, length = 100)
    private String correo;
}