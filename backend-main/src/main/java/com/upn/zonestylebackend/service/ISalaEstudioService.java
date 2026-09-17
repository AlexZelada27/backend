package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.SalaEstudio;

import java.util.List;
import java.util.Optional;

public interface ISalaEstudioService {

    List<SalaEstudio> findAll();

    Optional<SalaEstudio> findById(Integer id);

    SalaEstudio save(SalaEstudio salaEstudio);

    void deleteById(Integer id);
}