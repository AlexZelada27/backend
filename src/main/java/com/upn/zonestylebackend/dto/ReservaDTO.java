package com.upn.zonestylebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Integer idCliente;
    private Integer idEmpleado;
    private Integer idHorarioFijo;
    private Integer idPago;
    private Integer idSala;
    private String estado;
    private LocalDate fechaReserva;
    private Integer idHorario;
}

