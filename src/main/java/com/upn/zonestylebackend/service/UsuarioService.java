package com.upn.zonestylebackend.service;

import lombok.RequiredArgsConstructor;
import com.upn.zonestylebackend.model.Usuario;
import com.upn.zonestylebackend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario validAndSave(
            String nombres,
            String apellidos,
            String correo,
            String telefono,
            String password,
            Integer idRol
    ) {

        Usuario usuario = new Usuario();

        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos);
        usuario.setCorreo(correo);
        usuario.setTelefono(telefono);
        usuario.setPassword(password);
        usuario.setIdRol(idRol);

        return repository.save(usuario);
    }
}