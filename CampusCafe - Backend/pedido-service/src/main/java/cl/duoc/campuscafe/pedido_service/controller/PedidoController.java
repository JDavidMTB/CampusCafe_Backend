package cl.duoc.campuscafe.pedido_service.controller;

import cl.duoc.campuscafe.pedido_service.entity.Pedido;
import cl.duoc.campuscafe.pedido_service.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService service;

    @GetMapping
    public List<Pedido> listar() { return service.obtenerTodos(); }

    @PostMapping
    public ResponseEntity<Object> crear(@RequestBody Pedido pedido) {
        try {
            Pedido nuevoPedido = service.procesarPedido(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPedido);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
