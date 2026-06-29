package cl.duoc.campuscafe.detalle_pedido_service.repository;

import cl.duoc.campuscafe.detalle_pedido_service.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {}
