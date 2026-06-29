package cl.duoc.campuscafe.empleado_service.repository;

import cl.duoc.campuscafe.empleado_service.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    // Al extender de JpaRepository, Spring Boot crea automáticamente el findAll() en tiempo de compilación.
}
