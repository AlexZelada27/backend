package com.upn.zonestylebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // <-- 1. Importar JsonIgnore
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
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String cargo;

    @Column(nullable = false, length = 100)
    private String correo;

    @JsonIgnore // <-- 2. Usar JsonIgnore para evitar el error de proxy LAZY al serializar
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_usuario",
            unique = true,
            foreignKey = @ForeignKey(name = "FK_EMPLEADO_USUARIO")
    )
    private Usuario usuario;
}