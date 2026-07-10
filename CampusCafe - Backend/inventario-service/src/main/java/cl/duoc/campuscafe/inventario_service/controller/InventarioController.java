package cl.duoc.campuscafe.inventario_service.controller;

import cl.duoc.campuscafe.inventario_service.entity.Inventario;
import cl.duoc.campuscafe.inventario_service.service.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
@RequiredArgsConstructor
public class InventarioController {

    private final InventarioService service; // Conectado al Service

    @GetMapping
    public List<Inventario> listar() {
        return service.obtenerTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Inventario> crear(@RequestBody Inventario inventario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.actualizarStock(inventario));
    }
}
