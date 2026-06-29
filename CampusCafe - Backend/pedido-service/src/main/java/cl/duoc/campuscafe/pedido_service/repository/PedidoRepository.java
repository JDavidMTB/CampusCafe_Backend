package cl.duoc.campuscafe.pedido_service.repository;

import cl.duoc.campuscafe.pedido_service.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
