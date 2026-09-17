package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.TipoServicio;

import java.util.List;
import java.util.Optional;

public interface ITipoServicioService {

    List<TipoServicio> findAll();

    Optional<TipoServicio> findById(Integer id);

    TipoServicio save(TipoServicio tipoServicio);

    void deleteById(Integer id);
}