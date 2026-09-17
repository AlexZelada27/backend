package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Empleado;
import com.upn.zonestylebackend.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public List<Empleado> findAll() {
        return repository.findAll();
    }

    public Optional<Empleado> findById(Integer id) {
        return repository.findById(id);
    }

    public Empleado save(Empleado empleado) {
        return repository.save(empleado);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
