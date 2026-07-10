package cl.duoc.campuscafe.pedido_service.service;

import cl.duoc.campuscafe.pedido_service.entity.Pedido;
import cl.duoc.campuscafe.pedido_service.repository.PedidoRepository;
import cl.duoc.campuscafe.pedido_service.dto.ClienteRemoteDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private static final Logger log = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository repository;
    private final RestTemplate restTemplate;

    public List<Pedido> obtenerTodos() { return repository.findAll(); }

    public Pedido procesarPedido(Pedido pedido) {
        log.info("Iniciando validación remota del cliente ID: {}", pedido.getClienteId());

        // Apuntamos remotamente al puerto del Cliente Service
        String urlCliente = "http://localhost:8083/api/clientes/" + pedido.getClienteId();

        try {
            // Consulta REST sincrónica por HTTP GET
            ClienteRemoteDTO cliente = restTemplate.getForObject(urlCliente, ClienteRemoteDTO.class);
            if (cliente == null) {
                throw new RuntimeException("El cliente remoto no devolvió datos válidos.");
            }
            log.info("Cliente verificado exitosamente: {} ({})", cliente.getNombre(), cliente.getEmail());

        } catch (Exception e) {
            log.error("Fallo de negocio: No se puede registrar el pedido porque el cliente {} no existe en cliente-service", pedido.getClienteId());
            throw new RuntimeException("Operación cancelada: Cliente no registrado en el sistema universitario.");
        }

        pedido.setFechaPedido(LocalDateTime.now());
        log.info("Guardando Pedido en base de datos local por un total de: ${}", pedido.getTotal());
        return repository.save(pedido);
    }
}
