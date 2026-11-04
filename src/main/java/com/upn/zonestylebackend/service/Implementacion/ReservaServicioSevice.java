package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.ReservaServicio;
import com.upn.zonestylebackend.repository.IReservaServicioRepository;
import com.upn.zonestylebackend.service.IReservaServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaServicioService implements IReservaServicioService {

    private final IReservaServicioRepository repository;

    @Override
    public List<ReservaServicio> findAll() { return repository.findAll(); }

    @Override
    public Optional<ReservaServicio> findById(Integer id) { return repository.findById(id); }

    @Override
    public ReservaServicio save(ReservaServicio reservaServicio) { return repository.save(reservaServicio); }

    @Override
    public void deleteById(Integer id) { repository.deleteById(id); }
}