package com.upn.zonestylebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioDTO {

    private LocalDate fecha;
    private String horaInicio;
    private String horaFin;
    private Boolean reservado;
}

