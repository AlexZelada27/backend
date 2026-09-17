package com.upn.zonestylebackend.service.Implementacion;

public class HorarioService {
    package com.upn.zonestylebackend.service;

    public interface IHorario {
    }
package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.Horario;
import com.upn.zonestylebackend.repository.IHorarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    @RequiredArgsConstructor
    public class HorarioService {

        private final IHorarioRepository repository;

        public List<Horario> findAll() {
            return repository.findAll();
        }

        public Optional<Horario> findById(Integer id) {
            return repository.findById(id);
        }

        public Horario save(Horario horario) {
            return repository.save(horario);
        }

        public void deleteById(Integer id) {
            repository.deleteById(id);
        }
    }

}
