package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.Horario;

import java.util.List;
import java.util.Optional;

public interface IHorarioService {

    List<Horario> findAll();

    Optional<Horario> findById(Integer id);

    Horario save(Horario horario);

    void deleteById(Integer id);
}