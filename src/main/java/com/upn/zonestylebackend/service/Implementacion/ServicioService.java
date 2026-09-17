package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Servicio;
import com.upn.zonestylebackend.repository.IServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicioService {

    private final IServicioRepository repository;

    public List<Servicio> findAll() {
        return repository.findAll();
    }

    public Optional<Servicio> findById(Integer id) {
        return repository.findById(id);
    }

    public Servicio save(Servicio servicio) {
        return repository.save(servicio);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
