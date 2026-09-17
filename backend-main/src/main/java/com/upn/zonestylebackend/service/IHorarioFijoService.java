package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.HorarioFijo;

import java.util.List;
import java.util.Optional;

public interface IHorarioFijoService {

    List<HorarioFijo> findAll();

    Optional<HorarioFijo> findById(Integer id);

    HorarioFijo save(HorarioFijo horarioFijo);

    void deleteById(Integer id);
}