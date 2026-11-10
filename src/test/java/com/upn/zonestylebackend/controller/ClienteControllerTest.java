package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.Cliente;
import com.upn.zonestylebackend.service.Implementacion.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteControllerTest {

    @Test
    void listarClientesDevuelveResultadosDelServicio() {
        ClienteService service = mock(ClienteService.class);
        Cliente cliente = new Cliente();
        when(service.findAll()).thenReturn(List.of(cliente));

        ClienteController controller = new ClienteController(service);

        assertEquals(List.of(cliente), controller.getAll());
        verify(service).findAll();
    }

    @Test
    void clienteInexistenteDevuelve404() {
        ClienteService service = mock(ClienteService.class);
        when(service.findById(99)).thenReturn(Optional.empty());

        ClienteController controller = new ClienteController(service);

        assertEquals(HttpStatus.NOT_FOUND, controller.getById(99).getStatusCode());
    }
}
