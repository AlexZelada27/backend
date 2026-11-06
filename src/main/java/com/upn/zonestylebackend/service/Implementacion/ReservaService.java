package com.upn.zonestylebackend.service.Implementacion;

import com.upn.zonestylebackend.dto.ReservaDTO;
import com.upn.zonestylebackend.model.*;
import com.upn.zonestylebackend.repository.*;
import com.upn.zonestylebackend.service.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaService implements IReservaService {

    private final IReservaRepository IReservaRepository;
    private final IClienteRepository IClienteRepository;
    private final IEmpleadoRepository IEmpleadoRepository;
    private final IHorarioFijoRepository IHorarioFijoRepository;
    private final ISalaEstudioRepository ISalaEstudioRepository;
    private final IServicioRepository IServicioRepository;
    private final IPagoRepository IPagoRepository;

    @Override
    public List<Reserva> findAll() {
        return IReservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(Integer id) {
        return IReservaRepository.findById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return IReservaRepository.save(reserva);
    }

    @Override
    public void deleteById(Integer id) {
        IReservaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Reserva registrarReservaCompleta(ReservaDTO dto) {
        try {
            // 1. Buscar las entidades relacionadas
            Cliente cliente = IClienteRepository.findById(dto.getIdCliente())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + dto.getIdCliente()));
            Empleado empleado = IEmpleadoRepository.findById(dto.getIdEmpleado())
                    .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + dto.getIdEmpleado()));
            HorarioFijo horarioFijo = IHorarioFijoRepository.findById(dto.getIdHorarioFijo())
                    .orElseThrow(() -> new RuntimeException("Horario Fijo no encontrado con ID: " + dto.getIdHorarioFijo()));
            SalaEstudio sala = ISalaEstudioRepository.findById(dto.getIdSala())
                    .orElseThrow(() -> new RuntimeException("Sala de Estudio no encontrada con ID: " + dto.getIdSala()));

            // 2. Inicializar la Reserva principal
            Reserva reserva = new Reserva();
            reserva.setCliente(cliente);
            reserva.setEmpleado(empleado);
            reserva.setHorarioFijo(horarioFijo);
            reserva.setSala(sala);
            reserva.setEstado(dto.getEstado());
            reserva.setFechaReserva(dto.getFechaReserva());

            // 3. Iterar los servicios seleccionados, acumular la suma de precios y armar la tabla intermedia
            double montoTotal = 0.0;
            List<ReservaServicio> listaReservaServicios = new ArrayList<>();

            for (Integer idServicio : dto.getIdsServicios()) {
                Servicio servicio = IServicioRepository.findById(idServicio)
                        .orElseThrow(() -> new RuntimeException("Servicio no encontrado con ID: " + idServicio));

                montoTotal += servicio.getPrecio(); // Suma el precio del servicio

                ReservaServicio rs = new ReservaServicio();
                rs.setReserva(reserva);
                rs.setServicio(servicio);
                rs.setPrecio(servicio.getPrecio()); // Guarda el precio al momento de la reserva
                listaReservaServicios.add(rs);
            }

            // 4. Crear y guardar automáticamente el Pago con el monto total calculado
            Pago pago = new Pago();
            pago.setMonto(montoTotal);
            pago.setMetodoPago(dto.getMetodoPago());
            Pago pagoGuardado = IPagoRepository.save(pago);

            // 5. Asignar el pago y la lista de servicios a la reserva
            reserva.setPago(pagoGuardado);
            reserva.setServicios(listaReservaServicios);

            // 6. Guardar la reserva completa en cascada
            return IReservaRepository.save(reserva);

        } catch (Exception e) {
            throw new RuntimeException("Error detallado al registrar la reserva: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional
    public Reserva actualizarReserva(Integer id, ReservaDTO dto) {
        // 1. Buscar si la reserva existe
        Reserva reservaExistente = IReservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con ID: " + id));

        // 2. Buscar las entidades relacionadas actualizadas
        Cliente cliente = IClienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + dto.getIdCliente()));
        Empleado empleado = IEmpleadoRepository.findById(dto.getIdEmpleado())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + dto.getIdEmpleado()));
        HorarioFijo horarioFijo = IHorarioFijoRepository.findById(dto.getIdHorarioFijo())
                .orElseThrow(() -> new RuntimeException("Horario Fijo no encontrado con ID: " + dto.getIdHorarioFijo()));
        SalaEstudio sala = ISalaEstudioRepository.findById(dto.getIdSala())
                .orElseThrow(() -> new RuntimeException("Sala de Estudio no encontrada con ID: " + dto.getIdSala()));

        // 3. Actualizar campos principales
        reservaExistente.setCliente(cliente);
        reservaExistente.setEmpleado(empleado);
        reservaExistente.setHorarioFijo(horarioFijo);
        reservaExistente.setSala(sala);
        reservaExistente.setEstado(dto.getEstado());
        reservaExistente.setFechaReserva(dto.getFechaReserva());

        // 4. Recalcular servicios y el monto total si se envían
        double montoTotal = 0.0;
        if (dto.getIdsServicios() != null) {
            List<ReservaServicio> listaReservaServicios = new ArrayList<>();
            for (Integer idServicio : dto.getIdsServicios()) {
                Servicio servicio = IServicioRepository.findById(idServicio)
                        .orElseThrow(() -> new RuntimeException("Servicio no encontrado con ID: " + idServicio));

                montoTotal += servicio.getPrecio();

                ReservaServicio rs = new ReservaServicio();
                rs.setReserva(reservaExistente);
                rs.setServicio(servicio);
                rs.setPrecio(servicio.getPrecio());
                listaReservaServicios.add(rs);
            }
            reservaExistente.setServicios(listaReservaServicios);
        }

        // 5. Actualizar el pago asociado
        if (reservaExistente.getPago() != null) {
            Pago pago = reservaExistente.getPago();
            if (montoTotal > 0) {
                pago.setMonto(montoTotal);
            }
            if (dto.getMetodoPago() != null) {
                pago.setMetodoPago(dto.getMetodoPago());
            }
            IPagoRepository.save(pago);
        }

        // 6. Guardar y retornar la reserva actualizada
        return IReservaRepository.save(reservaExistente);
    }
}