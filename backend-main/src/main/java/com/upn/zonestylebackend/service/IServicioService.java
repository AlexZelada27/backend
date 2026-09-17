package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.Servicio;

import java.util.List;
import java.util.Optional;

public interface IServicioService {

    List<Servicio> findAll();

    Optional<Servicio> findById(Integer id);

    Servicio save(Servicio servicio);

    void deleteById(Integer id);
}