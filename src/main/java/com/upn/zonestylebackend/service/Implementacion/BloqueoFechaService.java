package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.BloqueoFecha;
import com.upn.zonestylebackend.repository.IBloqueoFechaRepo;
import com.upn.zonestylebackend.service.IBloqueoFechaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BloqueoFechaService implements IBloqueoFechaService {

    private final IBloqueoFechaRepo repository;

    @Override
    public List<BloqueoFecha> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<BloqueoFecha> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public BloqueoFecha save(BloqueoFecha bloqueoFecha) {
        return repository.save(bloqueoFecha);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}