package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Cliente;
import com.upn.zonestylebackend.repository.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final IClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(Integer id) {
        return repository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
