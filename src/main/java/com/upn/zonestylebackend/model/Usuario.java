package com.upn.zonestylebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // <-- 1. Importa esto
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @JsonIgnore // <-- 2. Añade esto para evitar que el rol serialice de regreso al usuario y cause bucle
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rol rol;

    @Column(name = "nombres", length = 100)
    private String nombres;

    @Column(name = "apellidos", length = 100)
    private String apellidos;

    @Column(name = "correo", length = 150)
    private String correo;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "estado", length = 20)
    private String estado;
}