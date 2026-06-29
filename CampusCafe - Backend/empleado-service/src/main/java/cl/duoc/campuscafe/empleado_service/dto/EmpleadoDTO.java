package cl.duoc.campuscafe.empleado_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmpleadoDTO {
    @NotBlank(message = "El nombre del empleado es obligatorio")
    private String nombre;
    @NotBlank(message = "El rol es obligatorio")
    private String rol;
}
