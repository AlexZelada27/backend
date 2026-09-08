package com.upn.zonestylebackend.service;

import lombok.RequiredArgsConstructor;
import com.upn.zonestylebackend.model.Rol;
import org.springframework.stereotype.Service;
import com.upn.zonestylebackend.repository.RolRepository;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository repository;

    public Rol validAndSave(
            String nombre,
            String descripcion
    ) {

        Rol rol = new Rol();

        rol.setNombre(nombre);
        rol.setDescripcion(descripcion);
        rol.setEstado(true);

        return repository.save(rol);
    }
}