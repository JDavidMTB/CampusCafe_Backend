package cl.duoc.campuscafe.pedido_service.service;

import cl.duoc.campuscafe.pedido_service.entity.Pedido;
import cl.duoc.campuscafe.pedido_service.repository.PedidoRepository;
import cl.duoc.campuscafe.pedido_service.dto.ClienteRemoteDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final RestTemplate restTemplate;

    public List<Pedido> obtenerTodos() { return repository.findAll(); }

    public Pedido procesarPedido(Pedido pedido) {
        log.info("Iniciando validación remota del cliente ID: {}", pedido.getClienteId());


        String urlCliente = "http://cliente-service/api/clientes/" + pedido.getClienteId();

        try {
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