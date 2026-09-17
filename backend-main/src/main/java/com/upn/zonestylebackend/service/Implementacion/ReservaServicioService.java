package com.upn.zonestylebackend.service.Implementacion;

public class ReservaServicioService {
    @Service
    @RequiredArgsConstructor
    public static class ReservaServicioService {

        private final IReservaServicioRepository repository;

        // Listar todas las relaciones reserva-servicio
        public List<ReservaServicio> findAll() {
            return repository.findAll();
        }

        // Buscar por ID
        public Optional<ReservaServicio> findById(Integer id) {
            return repository.findById(id);
        }

        // Guardar o actualizar
        public ReservaServicio save(ReservaServicio reservaServicio) {
            return repository.save(reservaServicio);
        }

        // Eliminar por ID
        public void deleteById(Integer id) {
            repository.deleteById(id);
        }
    }
}
