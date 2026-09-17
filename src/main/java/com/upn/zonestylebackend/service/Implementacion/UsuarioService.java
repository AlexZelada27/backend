package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Usuario;
import com.upn.zonestylebackend.repository.IRolRepository;
import com.upn.zonestylebackend.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final IUsuarioRepository repository;
    private final IRolRepository rolRepository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        // Asignar fecha de registro si es nuevo
        if (usuario.getIdUsuario() == null && usuario.getFechaRegistro() == null) {
            usuario.setFechaRegistro(LocalDateTime.now());
        }
        // Asignar estado por defecto si no viene
        if (usuario.getEstado() == null) {
            usuario.setEstado("ACTIVO");
        }
        return repository.save(usuario);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}