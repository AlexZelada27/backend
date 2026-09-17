package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface IEmpleadoService {

    List<Empleado> findAll();

    Optional<Empleado> findById(Integer id);

    Empleado save(Empleado empleado);

    void deleteById(Integer id);
}