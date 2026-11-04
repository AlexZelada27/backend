package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Usuario;
import com.upn.zonestylebackend.repository.IUsuarioRepository;
import com.upn.zonestylebackend.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional // <- Esto mantiene la sesión abierta y soluciona el error 500 en las consultas GET
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() { return repository.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Integer id) { return repository.findById(id); }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        if (usuario.getIdUsuario() == null && usuario.getFechaRegistro() == null) {
            usuario.setFechaRegistro(LocalDateTime.now());
        }
        if (usuario.getEstado() == null) {
            usuario.setEstado("ACTIVO");
        }
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) { repository.deleteById(id); }
}