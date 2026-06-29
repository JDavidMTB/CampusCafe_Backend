package cl.duoc.campuscafe.pago_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pagos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoId;
    private String medioPago; // Ejemplo: Junaeb, Transbank
    private Double monto;
}
