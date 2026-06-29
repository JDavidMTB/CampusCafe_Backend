package cl.duoc.campuscafe.pago_service.repository;

import cl.duoc.campuscafe.pago_service.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Al heredar de JpaRepository<Pago, Long>, Spring automáticamente
    // inyecta los métodos findAll(), save(), findById(), deleteById(), etc.
}
