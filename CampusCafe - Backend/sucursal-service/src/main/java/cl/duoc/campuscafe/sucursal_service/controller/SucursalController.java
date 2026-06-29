package cl.duoc.campuscafe.sucursal_service.controller;

import cl.duoc.campuscafe.sucursal_service.entity.Sucursal;
import cl.duoc.campuscafe.sucursal_service.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
@RequiredArgsConstructor
public class SucursalController {
    private final SucursalRepository repository;

    @GetMapping
    public List<Sucursal> listar() { return repository.findAll(); }

    @PostMapping
    public ResponseEntity<Sucursal> crear(@RequestBody Sucursal sucursal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(sucursal));
    }
}
