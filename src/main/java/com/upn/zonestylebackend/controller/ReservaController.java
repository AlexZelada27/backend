package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.Reserva;
import com.upn.zonestylebackend.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService service;

    @GetMapping
    public List<Reserva> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Reserva create(@RequestBody Reserva reserva) {
        return service.save(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(
            @PathVariable Integer id,
            @RequestBody Reserva reserva) {

        return service.findById(id).map(existing -> {
            reserva.setIdReserva(existing.getIdReserva());
            return ResponseEntity.ok(service.save(reserva));
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