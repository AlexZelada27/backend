package com.upn.zonestylebackend.controller;

import com.upn.zonestylebackend.model.Pago;
import com.upn.zonestylebackend.service.IPagoService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PagoControllerTest {

    @Test
    void listarPagosDevuelveResultadosDelServicio() {
        IPagoService service = mock(IPagoService.class);
        Pago pago = new Pago();
        when(service.findAll()).thenReturn(List.of(pago));

        PagoController controller = new PagoController(service);

        assertEquals(List.of(pago), controller.getAll());
        verify(service).findAll();
    }

    @Test
    void pagoInexistenteDevuelve404() {
        IPagoService service = mock(IPagoService.class);
        when(service.findById(99)).thenReturn(Optional.empty());

        PagoController controller = new PagoController(service);

        assertEquals(HttpStatus.NOT_FOUND, controller.getById(99).getStatusCode());
    }
}
