package com.upn.zonestylebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloqueoFechaDTO {

    private Integer idBloqueo;
    private LocalDate fecha;
    private Integer idHorarioFijo;
    private String motivo;
}