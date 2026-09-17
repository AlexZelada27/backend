package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.Pago;

import java.util.List;
import java.util.Optional;

public interface IPagoService {

    List<Pago> findAll();

    Optional<Pago> findById(Integer id);

    Pago save(Pago pago);

    void deleteById(Integer id);
}