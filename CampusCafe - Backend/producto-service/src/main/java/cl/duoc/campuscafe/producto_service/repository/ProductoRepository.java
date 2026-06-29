package cl.duoc.campuscafe.producto_service.repository;

import cl.duoc.campuscafe.producto_service.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}