package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface IReservaService {

    List<Reserva> findAll();

    Optional<Reserva> findById(Integer id);

    Reserva save(Reserva reserva);

    void deleteById(Integer id);
}