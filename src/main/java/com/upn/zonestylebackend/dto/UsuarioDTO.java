package com.upn.zonestylebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Integer idRol;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String password;
    private String estado;
}

