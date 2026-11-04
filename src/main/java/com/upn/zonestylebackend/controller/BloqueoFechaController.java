package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.dto.BloqueoFechaDTO;
import com.upn.zonestylebackend.model.BloqueoFecha;
import com.upn.zonestylebackend.model.HorarioFijo;
import com.upn.zonestylebackend.service.Implementacion.BloqueoFechaService;
import com.upn.zonestylebackend.service.IHorarioFijoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/bloqueos")
@RequiredArgsConstructor
public class BloqueoFechaController {

    private final BloqueoFechaService service;
    private final IHorarioFijoService horarioFijoService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<BloqueoFechaDTO> getAll() {
        return service.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloqueoFechaDTO> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(obj -> ResponseEntity.ok(convertToDto(obj)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<BloqueoFechaDTO> create(@Valid @RequestBody BloqueoFechaDTO dto) throws Exception {
        BloqueoFecha modelo = convertToModel(dto);

        if (dto.getIdHorarioFijo() != null) {
            HorarioFijo hf = horarioFijoService.findById(dto.getIdHorarioFijo()).orElse(null);
            modelo.setHorarioFijo(hf);
        } else {
            modelo.setHorarioFijo(null);
        }

        BloqueoFecha guardado = service.save(modelo);
        return new ResponseEntity<>(convertToDto(guardado), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<BloqueoFechaDTO> update(@PathVariable Integer id, @Valid @RequestBody BloqueoFechaDTO dto) {
        return service.findById(id).map(existing -> {
            dto.setIdBloqueo(id);
            BloqueoFecha modelo = convertToModel(dto);

            if (dto.getIdHorarioFijo() != null) {
                HorarioFijo hf = horarioFijoService.findById(dto.getIdHorarioFijo()).orElse(null);
                modelo.setHorarioFijo(hf);
            } else {
                modelo.setHorarioFijo(null);
            }

            BloqueoFecha actualizado = service.save(modelo);
            return ResponseEntity.ok(convertToDto(actualizado));
        }).orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private BloqueoFechaDTO convertToDto(BloqueoFecha obj) {
        BloqueoFechaDTO dto = modelMapper.map(obj, BloqueoFechaDTO.class);
        if (obj.getHorarioFijo() != null) {
            dto.setIdHorarioFijo(obj.getHorarioFijo().getIdHorarioFijo());
        }
        return dto;
    }

    private BloqueoFecha convertToModel(BloqueoFechaDTO dto) {
        return modelMapper.map(dto, BloqueoFecha.class);
    }
}