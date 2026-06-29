package cl.duoc.campuscafe.cliente_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @Email(message = "El formato del email es inválido")
    @NotBlank(message = "El email es obligatorio")
    private String email;
}
