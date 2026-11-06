package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.dto.ReservaDTO;
import com.upn.zonestylebackend.model.Reserva;
import com.upn.zonestylebackend.service.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final IReservaService service;

    @GetMapping
    public List<Reserva> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getById(@PathVariable Integer id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ReservaDTO dto) {
        service.registrarReservaCompleta(dto);
        return ResponseEntity.ok("¡Reserva y pago registrados con éxito!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Integer id, @RequestBody ReservaDTO dto) {
        // Llama al método de actualización en tu capa de servicio
        Reserva reservaActualizada = service.actualizarReserva(id, dto);
        return ResponseEntity.ok(reservaActualizada);
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