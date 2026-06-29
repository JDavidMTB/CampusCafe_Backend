package cl.duoc.campuscafe.producto_service.controller;

import cl.duoc.campuscafe.producto_service.entity.Producto;
import cl.duoc.campuscafe.producto_service.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;
import cl.duoc.campuscafe.producto_service.dto.ProductoDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService service;

    @GetMapping
    public List<Producto> listar() {
        return service.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@Valid @RequestBody ProductoDTO dto) {
        Producto producto = Producto.builder()
                .nombre(dto.getNombre())
                .precio(dto.getPrecio())
                .stock(dto.getStock())
                .categoriaId(dto.getCategoriaId())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.obtenerPorId(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProductoDTO dto) {

        Producto productoActualizado = Producto.builder()
                .nombre(dto.getNombre())
                .precio(dto.getPrecio())
                .stock(dto.getStock())
                .categoriaId(dto.getCategoriaId())
                .build();

        return ResponseEntity.ok(service.actualizar(id, productoActualizado));
    }


}