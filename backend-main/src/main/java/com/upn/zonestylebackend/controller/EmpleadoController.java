package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.Empleado;
import com.upn.zonestylebackend.service.Implementacion.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Empleado")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService service;

    @GetMapping
    public List<Empleado> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Empleado create(@RequestBody Empleado empleado) {
        return service.save(empleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(@PathVariable Integer id, @RequestBody Empleado empleado) {
        return service.findById(id).map(existing -> {
            empleado.setIdEmpleado(existing.getIdEmpleado());
            return ResponseEntity.ok(service.save(empleado));
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
