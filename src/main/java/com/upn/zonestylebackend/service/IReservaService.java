package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.dto.ReservaDTO;
import com.upn.zonestylebackend.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface IReservaService {
    List<Reserva> findAll();
    Optional<Reserva> findById(Integer id);
    Reserva save(Reserva reserva);
    void deleteById(Integer id);

    // Método para registrar la reserva con pago automático y servicios múltiples
    Reserva registrarReservaCompleta(ReservaDTO dto);

    // Método para actualizar la reserva
    Reserva actualizarReserva(Integer id, ReservaDTO dto);
}