package cl.duoc.campuscafe.reporte_service.controller;

import cl.duoc.campuscafe.reporte_service.entity.Reporte;
import cl.duoc.campuscafe.reporte_service.repository.ReporteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {
    private final ReporteRepository repository;

    @GetMapping
    public List<Reporte> listar() { return repository.findAll(); }

    @PostMapping
    public Reporte generar(@RequestBody Reporte reporte) {
        reporte.setFechaGeneracion(LocalDateTime.now());
        return repository.save(reporte);
    }
}
