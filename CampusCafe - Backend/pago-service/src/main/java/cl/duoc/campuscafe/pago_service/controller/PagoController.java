package cl.duoc.campuscafe.pago_service.controller;

import cl.duoc.campuscafe.pago_service.entity.Pago;
import cl.duoc.campuscafe.pago_service.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService service; // Conectado al Service

    @GetMapping
    public List<Pago> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Pago> crear(@RequestBody Pago pago) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarPago(pago));
    }
}