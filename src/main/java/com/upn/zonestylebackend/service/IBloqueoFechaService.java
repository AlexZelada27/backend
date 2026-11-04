package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.BloqueoFecha;
import java.util.List;
import java.util.Optional;

public interface IBloqueoFechaService {
    List<BloqueoFecha> findAll();
    Optional<BloqueoFecha> findById(Integer id);
    BloqueoFecha save(BloqueoFecha bloqueoFecha);
    void deleteById(Integer id);
}