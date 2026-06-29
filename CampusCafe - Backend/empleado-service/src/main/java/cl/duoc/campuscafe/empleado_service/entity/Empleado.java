package cl.duoc.campuscafe.empleado_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empleados")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String rol; // Ejemplo: Barista, Cajero
}
