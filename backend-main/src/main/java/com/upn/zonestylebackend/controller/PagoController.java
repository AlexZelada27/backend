package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.Pago;
import com.upn.zonestylebackend.service.Implementacion.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Pago")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService.PagoService service;

    @GetMapping
    public List<Pago> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pago create(@RequestBody Pago pago) {
        return service.save(pago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> update(
            @PathVariable Integer id,
            @RequestBody Pago pago) {

        return service.findById(id).map(existing -> {
            pago.setIdPago(existing.getIdPago());
            return ResponseEntity.ok(service.save(pago));
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