package com.upn.zonestylebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaServicioDTO {

    private Integer idReserva;
    private Integer idServicio;
    private Double precio;
}

