package com.upn.zonestylebackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Constructor sin parametros
@AllArgsConstructor // Constructor con parametros
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity // Este objeto tiene una representacion de db ---> tabla
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRol;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(length = 150)
    private String descripcion;

    @Column(nullable = false)
    private Boolean estado;
}