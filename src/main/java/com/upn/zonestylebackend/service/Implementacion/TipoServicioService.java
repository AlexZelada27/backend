package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.TipoServicio;
import com.upn.zonestylebackend.repository.ITipoServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoServicioService {

    private final ITipoServicioRepository repository;

    public List<TipoServicio> findAll() {
        return repository.findAll();
    }

    public Optional<TipoServicio> findById(Integer id) {
        return repository.findById(id);
    }

    public TipoServicio save(TipoServicio tipoServicio) {
        return repository.save(tipoServicio);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
