package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.HorarioFijo;
import com.upn.zonestylebackend.repository.IHorarioFijoRepository;
import com.upn.zonestylebackend.service.IHorarioFijoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HorarioFijoService implements IHorarioFijoService {

    private final IHorarioFijoRepository repository;

    @Override
    public List<HorarioFijo> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<HorarioFijo> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public HorarioFijo save(HorarioFijo horarioFijo) {
        return repository.save(horarioFijo);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}