package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {

    List<Rol> findAll();

    Optional<Rol> findById(Integer id);

    Rol save(Rol rol);

    void deleteById(Integer id);
}
