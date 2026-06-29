package cl.duoc.campuscafe.detalle_pedido_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalles_pedido")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoId;
    private Long productoId;
    private Integer cantidad;
    private Double subtotal;
}
