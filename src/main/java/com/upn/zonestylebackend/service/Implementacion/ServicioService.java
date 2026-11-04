package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Servicio;
import com.upn.zonestylebackend.repository.IServicioRepository;
import com.upn.zonestylebackend.service.IServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicioService implements IServicioService {

    private final IServicioRepository repository;

    @Override
    public List<Servicio> findAll() { return repository.findAll(); }

    @Override
    public Optional<Servicio> findById(Integer id) { return repository.findById(id); }

    @Override
    public Servicio save(Servicio servicio) { return repository.save(servicio); }

    @Override
    public void deleteById(Integer id) { repository.deleteById(id); }
}