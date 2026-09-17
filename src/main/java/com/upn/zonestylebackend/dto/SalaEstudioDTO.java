package com.upn.zonestylebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaEstudioDTO {

    private String nombre;
    private String direccion;
    private String descripcion;
    private Integer capacidad;
}

