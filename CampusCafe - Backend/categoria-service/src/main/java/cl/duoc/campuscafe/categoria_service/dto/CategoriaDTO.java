package cl.duoc.campuscafe.categoria_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaDTO {
    @NotBlank(message = "El nombre de la categoría es obligatorio")
    private String nombre;
}