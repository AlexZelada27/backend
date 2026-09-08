package com.upn.zonestylebackend.controller;

import lombok.RequiredArgsConstructor;
import com.upn.zonestylebackend.model.Usuario;
import com.upn.zonestylebackend.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080/v1/Usuario
@RestController
@RequestMapping("/v1/Usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public Usuario searchUsuario() {
        return service.validAndSave(
                "Gregory",
                "Lopez",
                "gregory@gmail.com",
                "987654321",
                "123456",
                1
        );
    }
}