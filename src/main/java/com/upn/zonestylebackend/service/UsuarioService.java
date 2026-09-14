package com.upn.zonestylebackend.service;

import lombok.RequiredArgsConstructor;
import com.upn.zonestylebackend.model.Rol;
import com.upn.zonestylebackend.model.Usuario;
import com.upn.zonestylebackend.repository.RolRepository;
import com.upn.zonestylebackend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final RolRepository rolRepository;


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


        Rol rol = rolRepository.findById(idRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        usuario.setRol(rol);


        return repository.save(usuario);
    }
}