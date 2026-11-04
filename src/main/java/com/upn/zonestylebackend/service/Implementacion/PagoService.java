package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Pago;
import com.upn.zonestylebackend.repository.IPagoRepository;
import com.upn.zonestylebackend.service.IPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagoService implements IPagoService {

    private final IPagoRepository repository;

    @Override
    public List<Pago> findAll() { return repository.findAll(); }

    @Override
    public Optional<Pago> findById(Integer id) { return repository.findById(id); }

    @Override
    public Pago save(Pago pago) { return repository.save(pago); }

    @Override
    public void deleteById(Integer id) { repository.deleteById(id); }
}