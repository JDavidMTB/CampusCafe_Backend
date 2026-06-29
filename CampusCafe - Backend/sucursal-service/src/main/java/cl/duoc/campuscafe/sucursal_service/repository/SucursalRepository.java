package cl.duoc.campuscafe.sucursal_service.repository;

import cl.duoc.campuscafe.sucursal_service.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}