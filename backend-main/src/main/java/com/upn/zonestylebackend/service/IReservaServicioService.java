package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.ReservaServicio;

import java.util.List;
import java.util.Optional;

public interface IReservaServicioService {

    List<ReservaServicio> findAll();

    Optional<ReservaServicio> findById(Integer id);

    ReservaServicio save(ReservaServicio reservaServicio);

    void deleteById(Integer id);
}