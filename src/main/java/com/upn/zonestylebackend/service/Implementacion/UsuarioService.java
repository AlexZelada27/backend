package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Cliente;
import com.upn.zonestylebackend.model.Empleado;
import com.upn.zonestylebackend.model.Usuario;
import com.upn.zonestylebackend.repository.IClienteRepository;
import com.upn.zonestylebackend.repository.IEmpleadoRepository;
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
@Transactional
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository repository;
    private final IClienteRepository clienteRepository;
    private final IEmpleadoRepository empleadoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        if (usuario.getIdUsuario() == null && usuario.getFechaRegistro() == null) {
            usuario.setFechaRegistro(LocalDateTime.now());
        }
        if (usuario.getEstado() == null) {
            usuario.setEstado("ACTIVO");
        }

        // 1. Guardamos el usuario base para obtener su ID generado en la BD
        Usuario usuarioGuardado = repository.save(usuario);

        // 2. Evaluamos directamente el ID del rol recibido para el registro automático
        if (usuario.getRol() != null && usuario.getRol().getIdRol() != null) {
            Integer idRol = usuario.getRol().getIdRol();
            String nombreCompleto = (usuario.getNombres() != null ? usuario.getNombres() : "") +
                    " " +
                    (usuario.getApellidos() != null ? usuario.getApellidos() : "");

            // ID 3 = Cliente, ID 2 = Empleado (puedes ajustarlo si tu BD usa otros IDs)
            if (idRol == 3) {
                Cliente cliente = new Cliente();
                cliente.setNombre(nombreCompleto.trim().isEmpty() ? "Cliente Nuevo" : nombreCompleto.trim());
                cliente.setCorreo(usuario.getCorreo());
                cliente.setTelefono(usuario.getTelefono() != null ? usuario.getTelefono() : "000000000");
                cliente.setUsuario(usuarioGuardado); // Vinculación OneToOne con el usuario
                clienteRepository.save(cliente);

            } else if (idRol == 2) {
                Empleado empleado = new Empleado();
                empleado.setNombre(nombreCompleto.trim().isEmpty() ? "Empleado Nuevo" : nombreCompleto.trim());
                empleado.setCorreo(usuario.getCorreo());
                empleado.setCargo("Personal");
                empleado.setUsuario(usuarioGuardado); // Vinculación OneToOne con el usuario
                empleadoRepository.save(empleado);
            }
        }

        return usuarioGuardado;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}