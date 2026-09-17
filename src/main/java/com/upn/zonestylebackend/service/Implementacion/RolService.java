package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Rol;
import com.upn.zonestylebackend.repository.IRolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolService {

    private final IRolRepository repository;

    public List<Rol> findAll() {
        return repository.findAll();
    }

    public Optional<Rol> findById(Integer id) {
        return repository.findById(id);
    }

    public Rol save(Rol rol) {
        return repository.save(rol);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}