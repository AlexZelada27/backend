package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(Integer id);

    Cliente save(Cliente cliente);

    void deleteById(Integer id);
}