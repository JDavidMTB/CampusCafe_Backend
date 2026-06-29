package cl.duoc.campuscafe.pedido_service.dto;

import lombok.Data;

@Data
public class ClienteRemoteDTO {
    private Long id;
    private String nombre;
    private String email;
}
