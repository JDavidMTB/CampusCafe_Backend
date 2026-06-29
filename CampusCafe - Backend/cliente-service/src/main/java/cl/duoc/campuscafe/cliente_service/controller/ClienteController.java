package cl.duoc.campuscafe.cliente_service.controller;

import cl.duoc.campuscafe.cliente_service.entity.Cliente;
import cl.duoc.campuscafe.cliente_service.dto.ClienteDTO;
import cl.duoc.campuscafe.cliente_service.repository.ClienteRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteRepository repository;

    @GetMapping
    public List<Cliente> listar() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@Valid @RequestBody ClienteDTO dto) {
        Cliente cliente = Cliente.builder().nombre(dto.getNombre()).email(dto.getEmail()).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }
}
