package com.upn.zonestylebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {
    private Integer idCliente;
    private Integer idEmpleado;
    private Integer idHorarioFijo;
    private Integer idSala;
    private String estado;
    private LocalDate fechaReserva;

    // Campos para el registro y actualización completa
    private String metodoPago;
    private List<Integer> idsServicios;
}