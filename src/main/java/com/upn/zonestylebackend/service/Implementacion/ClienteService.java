package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.model.Cliente;
import com.upn.zonestylebackend.repository.IClienteRepository;
import com.upn.zonestylebackend.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private final IClienteRepository repository;

    @Override
    public List<Cliente> findAll() { return repository.findAll(); }

    @Override
    public Optional<Cliente> findById(Integer id) { return repository.findById(id); }

    @Override
    public Cliente save(Cliente cliente) { return repository.save(cliente); }

    @Override
    public void deleteById(Integer id) { repository.deleteById(id); }
}