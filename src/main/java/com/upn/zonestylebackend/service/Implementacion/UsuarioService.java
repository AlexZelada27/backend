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
        if (usuario.getEstado() == null || usuario.getEstado().isBlank()) {
            usuario.setEstado("ACTIVO");
        }

        if (usuario.getIdUsuario() != null && (usuario.getPassword() == null || usuario.getPassword().isBlank())) {
            repository.findById(usuario.getIdUsuario()).ifPresent(actual ->
                    usuario.setPassword(actual.getPassword())
            );
        }

        // 1. Guardamos el usuario base para obtener su ID generado en la BD
        Usuario usuarioGuardado = repository.save(usuario);

        // 2. Evaluamos directamente el ID del rol recibido para el registro automático
        if (usuarioGuardado.getRol() != null && usuarioGuardado.getRol().getIdRol() != null) {
            Integer idRol = usuarioGuardado.getRol().getIdRol();
            String nombreCompleto = ((usuarioGuardado.getNombres() != null ? usuarioGuardado.getNombres() : "") +
                    " " +
                    (usuarioGuardado.getApellidos() != null ? usuarioGuardado.getApellidos() : "")).trim();

            // ID 3 = CLIENTE, ID 2 = EMPLEADO
            if (idRol == 3) {
                boolean yaExisteCliente = clienteRepository.findAll().stream()
                        .anyMatch(c -> c.getUsuario() != null
                                && c.getUsuario().getIdUsuario() != null
                                && c.getUsuario().getIdUsuario().equals(usuarioGuardado.getIdUsuario()));

                if (!yaExisteCliente) {
                    Cliente cliente = new Cliente();
                    cliente.setNombre(nombreCompleto.isEmpty() ? "Cliente Nuevo" : nombreCompleto);
                    cliente.setCorreo(usuarioGuardado.getCorreo());
                    cliente.setTelefono(usuarioGuardado.getTelefono() != null ? usuarioGuardado.getTelefono() : "000000000");
                    cliente.setUsuario(usuarioGuardado);
                    clienteRepository.save(cliente);
                }
            } else if (idRol == 2) {
                boolean yaExisteEmpleado = empleadoRepository.findAll().stream()
                        .anyMatch(e -> e.getUsuario() != null
                                && e.getUsuario().getIdUsuario() != null
                                && e.getUsuario().getIdUsuario().equals(usuarioGuardado.getIdUsuario()));

                if (!yaExisteEmpleado) {
                    Empleado empleado = new Empleado();
                    empleado.setNombre(nombreCompleto.isEmpty() ? "Empleado Nuevo" : nombreCompleto);
                    empleado.setCorreo(usuarioGuardado.getCorreo());
                    empleado.setCargo("Personal");
                    empleado.setUsuario(usuarioGuardado);
                    empleadoRepository.save(empleado);
                }
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