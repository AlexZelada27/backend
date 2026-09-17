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

    @Service
    @RequiredArgsConstructor
    public static class SalaEstudioService {

        private final ISalaEstudioRepository repository;

        // Listar todas las salas de estudio
        public List<SalaEstudio> findAll() {
            return repository.findAll();
        }

        // Buscar sala de estudio por ID
        public Optional<SalaEstudio> findById(Integer id) {
            return repository.findById(id);
        }

        // Guardar o actualizar sala de estudio
        public SalaEstudio save(SalaEstudio salaEstudio) {
            return repository.save(salaEstudio);
        }

        // Eliminar sala de estudio por ID
        public void deleteById(Integer id) {
            repository.deleteById(id);
        }
    }
}
