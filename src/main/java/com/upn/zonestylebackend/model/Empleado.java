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
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEmpleado;


    @Column(nullable = false, length = 100)
    private String nombre;


    @Column(nullable = false, length = 50)
    private String cargo;


    @Column(nullable = false, length = 100)
    private String correo;
}