package cl.duoc.campuscafe.cliente_service.repository;

import cl.duoc.campuscafe.cliente_service.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}