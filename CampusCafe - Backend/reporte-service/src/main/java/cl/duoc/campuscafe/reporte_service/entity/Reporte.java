package cl.duoc.campuscafe.reporte_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reportes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoReporte; // Ejemplo: "Ventas Diarias"
    private String descripcion;
    private LocalDateTime fechaGeneracion;
}
