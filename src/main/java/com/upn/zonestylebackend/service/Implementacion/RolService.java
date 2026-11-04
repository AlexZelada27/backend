package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Rol;
import com.upn.zonestylebackend.repository.IRolRepository;
import com.upn.zonestylebackend.service.IRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolService implements IRolService {

    private final IRolRepository repository;

    @Override
    public List<Rol> findAll() { return repository.findAll(); }

    @Override
    public Optional<Rol> findById(Integer id) { return repository.findById(id); }

    @Override
    public Rol save(Rol rol) { return repository.save(rol); }

    @Override
    public void deleteById(Integer id) { repository.deleteById(id); }
}