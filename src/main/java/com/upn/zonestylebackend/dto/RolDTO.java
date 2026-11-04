package com.upn.zonestylebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolDTO {

    private String nombre;
    private String descripcion;
    private Boolean estado;
}

