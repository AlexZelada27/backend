package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.SalaEstudio;
import com.upn.zonestylebackend.repository.ISalaEstudioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalaEstudioService {

    private final ISalaEstudioRepository repository;

    public List<SalaEstudio> findAll() {
        return repository.findAll();
    }

    public Optional<SalaEstudio> findById(Integer id) {
        return repository.findById(id);
    }

    public SalaEstudio save(SalaEstudio salaEstudio) {
        return repository.save(salaEstudio);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
