package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.ReservaServicio;
import com.upn.zonestylebackend.service.ReservaServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ReservaServicio")
@RequiredArgsConstructor
public class ReservaServicioController {

    private final ReservaServicioService service;

    @GetMapping
    public List<ReservaServicio> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaServicio> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReservaServicio create(@RequestBody ReservaServicio reservaServicio) {
        return service.save(reservaServicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaServicio> update(
            @PathVariable Integer id,
            @RequestBody ReservaServicio reservaServicio) {

        return service.findById(id).map(existing -> {
            reservaServicio.setIdReservaServicio(existing.getIdReservaServicio());
            return ResponseEntity.ok(service.save(reservaServicio));
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