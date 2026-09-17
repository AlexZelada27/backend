package com.upn.zonestylebackend.service;

import com.upn.zonestylebackend.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Usuario> findAll();

    Optional<Usuario> findById(Integer id);

    Usuario save(Usuario usuario);

    void deleteById(Integer id);
}