package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.SalaEstudio;
import com.upn.zonestylebackend.service.Implementacion.SalaEstudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/SalaEstudio")
@RequiredArgsConstructor
public class SalaEstudioController {

    private final SalaEstudioService service;

    @GetMapping
    public List<SalaEstudio> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaEstudio> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SalaEstudio create(@RequestBody SalaEstudio salaEstudio) {
        return service.save(salaEstudio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaEstudio> update(@PathVariable Integer id, @RequestBody SalaEstudio salaEstudio) {
        return service.findById(id).map(existing -> {
            salaEstudio.setIdSala(existing.getIdSala());
            return ResponseEntity.ok(service.save(salaEstudio));
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
