package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.HorarioFijo;
import com.upn.zonestylebackend.service.HorarioFijoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/HorarioFijo")
@RequiredArgsConstructor
public class HorarioFijoController {

    private final HorarioFijoService service;

    @GetMapping
    public List<HorarioFijo> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioFijo> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HorarioFijo create(@RequestBody HorarioFijo horarioFijo) {
        return service.save(horarioFijo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioFijo> update(
            @PathVariable Integer id,
            @RequestBody HorarioFijo horarioFijo) {

        return service.findById(id).map(existing -> {
            horarioFijo.setIdHorarioFijo(existing.getIdHorarioFijo());
            return ResponseEntity.ok(service.save(horarioFijo));
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