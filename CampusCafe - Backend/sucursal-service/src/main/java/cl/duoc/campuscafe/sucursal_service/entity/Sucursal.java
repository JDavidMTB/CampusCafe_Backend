package cl.duoc.campuscafe.sucursal_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sucursales")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCampus; // Ejemplo: Campus San Joaquín
}
