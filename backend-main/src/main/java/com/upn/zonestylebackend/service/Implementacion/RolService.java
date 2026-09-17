package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Rol;
import com.upn.zonestylebackend.repository.IRolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolService {

    private final IRolRepository repository;

    public List<Rol> findAll() {
        return repository.findAll();
    }

    public Optional<Rol> findById(Integer id) {
        return repository.findById(id);
    }

    public Rol save(Rol rol) {
        return repository.save(rol);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Service
    @RequiredArgsConstructor
    public static class RolService {

        private final IRolRepository repository;

        // Listar todos los roles
        public List<Rol> findAll() {
            return repository.findAll();
        }

        // Buscar rol por ID
        public Optional<Rol> findById(Integer id) {
            return repository.findById(id);
        }

        // Guardar o actualizar rol
        public Rol save(Rol rol) {
            return repository.save(rol);
        }

        // Eliminar rol por ID
        public void deleteById(Integer id) {
            repository.deleteById(id);
        }
    }
}