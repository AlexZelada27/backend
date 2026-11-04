package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.TipoServicio;
import com.upn.zonestylebackend.repository.ITipoServicioRepository;
import com.upn.zonestylebackend.service.ITipoServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoServicioService implements ITipoServicioService {

    private final ITipoServicioRepository repository;

    @Override
    public List<TipoServicio> findAll() { return repository.findAll(); }

    @Override
    public Optional<TipoServicio> findById(Integer id) { return repository.findById(id); }

    @Override
    public TipoServicio save(TipoServicio tipoServicio) { return repository.save(tipoServicio); }

    @Override
    public void deleteById(Integer id) { repository.deleteById(id); }
}