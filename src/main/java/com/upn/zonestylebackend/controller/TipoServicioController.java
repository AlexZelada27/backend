package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.TipoServicio;
import com.upn.zonestylebackend.service.TipoServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/TipoServicio")
@RequiredArgsConstructor
public class TipoServicioController {

    private final TipoServicioService service;

    @GetMapping
    public List<TipoServicio> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoServicio> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoServicio create(@RequestBody TipoServicio tipoServicio) {
        return service.save(tipoServicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoServicio> update(@PathVariable Integer id, @RequestBody TipoServicio tipoServicio) {
        return service.findById(id).map(existing -> {
            tipoServicio.setIdTipoServicio(existing.getIdTipoServicio());
            return ResponseEntity.ok(service.save(tipoServicio));
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
