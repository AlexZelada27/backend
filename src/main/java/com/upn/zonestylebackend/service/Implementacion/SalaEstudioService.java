package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.SalaEstudio;
import com.upn.zonestylebackend.repository.ISalaEstudioRepository;
import com.upn.zonestylebackend.service.ISalaEstudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalaEstudioService implements ISalaEstudioService {

    private final ISalaEstudioRepository repository;

    @Override
    public List<SalaEstudio> findAll() { return repository.findAll(); }

    @Override
    public Optional<SalaEstudio> findById(Integer id) { return repository.findById(id); }

    @Override
    public SalaEstudio save(SalaEstudio salaEstudio) { return repository.save(salaEstudio); }

    @Override
    public void deleteById(Integer id) { repository.deleteById(id); }
}