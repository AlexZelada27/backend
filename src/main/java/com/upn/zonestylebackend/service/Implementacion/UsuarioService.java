package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Usuario;
import com.upn.zonestylebackend.repository.IUsuarioRepository;
import com.upn.zonestylebackend.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository repository;

    @Override
    public List<Usuario> findAll() { return repository.findAll(); }

    @Override
    public Optional<Usuario> findById(Integer id) { return repository.findById(id); }

    @Override
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
    public void deleteById(Integer id) { repository.deleteById(id); }
}