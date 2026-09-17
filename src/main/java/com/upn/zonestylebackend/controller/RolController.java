package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.Rol;
import com.upn.zonestylebackend.service.Implementacion.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Rol")
@RequiredArgsConstructor
public class RolController {

    private final RolService service;

    @GetMapping
    public List<Rol> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rol create(@RequestBody Rol rol) {
        return service.save(rol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> update(@PathVariable Integer id, @RequestBody Rol rol) {
        return service.findById(id).map(existing -> {
            rol.setIdRol(existing.getIdRol());
            return ResponseEntity.ok(service.save(rol));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}