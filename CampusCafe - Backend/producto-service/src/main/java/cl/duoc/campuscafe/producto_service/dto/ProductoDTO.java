package cl.duoc.campuscafe.producto_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductoDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Min(value = 1, message = "El precio debe ser mayor que 0")
    private Double precio;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull(message = "El ID de la categoría es obligatorio")
    private Long categoriaId;
}