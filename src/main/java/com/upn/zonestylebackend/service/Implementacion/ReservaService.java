package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Reserva;
import com.upn.zonestylebackend.repository.IReservaRepository;
import com.upn.zonestylebackend.service.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaService implements IReservaService {

    private final IReservaRepository repository;

    @Override
    public List<Reserva> findAll() { return repository.findAll(); }

    @Override
    public Optional<Reserva> findById(Integer id) { return repository.findById(id); }

    @Override
    public Reserva save(Reserva reserva) { return repository.save(reserva); }

    @Override
    public void deleteById(Integer id) { repository.deleteById(id); }
}