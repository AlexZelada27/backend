package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.Horario;
import com.upn.zonestylebackend.service.HorarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Horario")
@RequiredArgsConstructor
public class HorarioController {

    private final HorarioService service;

    @GetMapping
    public List<Horario> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Horario create(@RequestBody Horario horario) {
        return service.save(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> update(@PathVariable Integer id, @RequestBody Horario horario) {
        return service.findById(id).map(existing -> {
            horario.setIdHorario(existing.getIdHorario());
            return ResponseEntity.ok(service.save(horario));
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