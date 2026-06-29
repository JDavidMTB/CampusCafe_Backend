package cl.duoc.campuscafe.empleado_service.controller;

import cl.duoc.campuscafe.empleado_service.entity.Empleado;
import cl.duoc.campuscafe.empleado_service.dto.EmpleadoDTO;
import cl.duoc.campuscafe.empleado_service.repository.EmpleadoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoRepository repository;

    @GetMapping
    public List<Empleado> listar() { return repository.findAll(); }

    @PostMapping
    public ResponseEntity<Empleado> crear(@Valid @RequestBody EmpleadoDTO dto) {
        Empleado emp = Empleado.builder().nombre(dto.getNombre()).rol(dto.getRol()).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(emp));
    }
}