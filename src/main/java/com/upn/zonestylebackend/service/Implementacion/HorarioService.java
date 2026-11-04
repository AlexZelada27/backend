package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Horario;
import com.upn.zonestylebackend.repository.IHorarioRepository;
import com.upn.zonestylebackend.service.IHorarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HorarioService implements IHorarioService {

    private final IHorarioRepository repository;

    @Override
    public List<Horario> findAll() { return repository.findAll(); }

    @Override
    public Optional<Horario> findById(Integer id) { return repository.findById(id); }

    @Override
    public Horario save(Horario horario) { return repository.save(horario); }

    @Override
    public void deleteById(Integer id) { repository.deleteById(id); }
}