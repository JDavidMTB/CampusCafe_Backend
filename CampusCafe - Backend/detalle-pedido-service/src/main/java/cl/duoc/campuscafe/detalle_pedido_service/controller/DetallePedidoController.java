package cl.duoc.campuscafe.detalle_pedido_service.controller;

import cl.duoc.campuscafe.detalle_pedido_service.entity.DetallePedido;
import cl.duoc.campuscafe.detalle_pedido_service.repository.DetallePedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalles")
@RequiredArgsConstructor
public class DetallePedidoController {
    private final DetallePedidoRepository repository;

    @GetMapping
    public List<DetallePedido> listar() { return repository.findAll(); }

    @PostMapping
    public ResponseEntity<DetallePedido> crear(@RequestBody DetallePedido detalle) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(detalle));
    }
}
