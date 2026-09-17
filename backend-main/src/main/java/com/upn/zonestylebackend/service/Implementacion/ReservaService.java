package com.upn.zonestylebackend.service.Implementacion;

public class ReservaService {
    @Service
    @RequiredArgsConstructor
    public static class ReservaService {

        private final IReservaRepository repository;

        // Listar todas las reservas
        public List<Reserva> findAll() {
            return repository.findAll();
        }

        // Buscar reserva por ID
        public Optional<Reserva> findById(Integer id) {
            return repository.findById(id);
        }

        // Guardar o actualizar reserva
        public Reserva save(Reserva reserva) {
            return repository.save(reserva);
        }

        // Eliminar reserva por ID
        public void deleteById(Integer id) {
            repository.deleteById(id);
        }
    }
}
