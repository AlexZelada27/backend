package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.dto.ReservaServicioDTO;
import com.upn.zonestylebackend.model.ReservaServicio;
import com.upn.zonestylebackend.service.IReservaServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ReservaServicio")
@RequiredArgsConstructor
public class ReservaServicioController {

    private final IReservaServicioService service;

    @GetMapping
    public List<ReservaServicioDTO> getAll() {
        return service.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaServicioDTO> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(rs -> ResponseEntity.ok(toDTO(rs)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReservaServicio create(@RequestBody ReservaServicio reservaServicio) {
        return service.save(reservaServicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaServicio> update(@PathVariable Integer id, @RequestBody ReservaServicio reservaServicio) {
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

    private ReservaServicioDTO toDTO(ReservaServicio rs) {
        Integer idReserva = rs.getReserva() != null ? rs.getReserva().getIdReserva() : null;
        Integer idServicio = rs.getServicio() != null ? rs.getServicio().getIdServicio() : null;
        Double precio = rs.getPrecio() != null ? rs.getPrecio().doubleValue() : null;
        return new ReservaServicioDTO(idReserva, idServicio, precio);
    }
}