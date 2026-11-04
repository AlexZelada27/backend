package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Empleado;
import com.upn.zonestylebackend.repository.IEmpleadoRepository;
import com.upn.zonestylebackend.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoService implements IEmpleadoService {

    private final IEmpleadoRepository repository;

    @Override
    public List<Empleado> findAll() { return repository.findAll(); }

    @Override
    public Optional<Empleado> findById(Integer id) { return repository.findById(id); }

    @Override
    public Empleado save(Empleado empleado) { return repository.save(empleado); }

    @Override
    public void deleteById(Integer id) { repository.deleteById(id); }
}