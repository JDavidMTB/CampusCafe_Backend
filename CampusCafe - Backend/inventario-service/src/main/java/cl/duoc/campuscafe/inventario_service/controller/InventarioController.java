package cl.duoc.campuscafe.inventario_service.controller;

import cl.duoc.campuscafe.inventario_service.entity.Inventario;
import cl.duoc.campuscafe.inventario_service.repository.InventarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {
    private final InventarioRepository repository;

    @GetMapping
    public List<Inventario> listar() { return repository.findAll(); }

    @PostMapping
    public Inventario crear(@RequestBody Inventario inv) { return repository.save(inv); }
}
