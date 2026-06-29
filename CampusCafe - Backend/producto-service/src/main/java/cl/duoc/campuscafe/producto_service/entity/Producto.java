package cl.duoc.campuscafe.producto_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;

    private Long categoriaId;
}