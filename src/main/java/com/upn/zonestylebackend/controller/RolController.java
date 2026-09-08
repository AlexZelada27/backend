package com.upn.zonestylebackend.controller;

import lombok.RequiredArgsConstructor;
import com.upn.zonestylebackend.model.Rol;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.upn.zonestylebackend.service.RolService;

// http://localhost:8080/v1/Rol
// Inyeccion tipos: por metodo, por constructor, por atributo
@RestController
@RequestMapping("/v1/Rol")
@RequiredArgsConstructor
public class RolController {

    private final RolService service;

    // Inyeccion por constructor
    /*
    public RolController(RolService service) {
        this.service = service;
    }
    */

    @GetMapping
    public Rol searchRol() {

        return service.validAndSave(
                "Administrador",
                "Administrador del sistema"
        );
    }
}