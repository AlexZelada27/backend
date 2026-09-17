package com.upn.zonestylebackend.service.Implementacion;

public class PagoService {
    @Service
    @RequiredArgsConstructor
    public static class PagoService {

        private final IPagoRepository repository;

        // Listar todos los pagos
        public List<Pago> findAll() {
            return repository.findAll();
        }

        // Buscar pago por ID
        public Optional<Pago> findById(Integer id) {
            return repository.findById(id);
        }

        // Guardar o actualizar pago
        public Pago save(Pago pago) {
            return repository.save(pago);
        }

        // Eliminar pago por ID
        public void deleteById(Integer id) {
            repository.deleteById(id);
        }
    }
}
