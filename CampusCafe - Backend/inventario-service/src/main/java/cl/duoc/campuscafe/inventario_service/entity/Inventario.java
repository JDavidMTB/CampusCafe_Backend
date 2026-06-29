package cl.duoc.campuscafe.inventario_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventarios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String insumo; // Ejemplo: Granos de Café, Vasos
    private Integer cantidad;
}
