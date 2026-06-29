package cl.duoc.campuscafe.inventario_service.repository;

import cl.duoc.campuscafe.inventario_service.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    // Al extender de JpaRepository, Spring hereda automáticamente findAll(), save(), etc.
}
