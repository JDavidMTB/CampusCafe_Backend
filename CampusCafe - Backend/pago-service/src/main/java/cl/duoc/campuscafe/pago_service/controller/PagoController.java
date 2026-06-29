package cl.duoc.campuscafe.pago_service.controller;

import cl.duoc.campuscafe.pago_service.entity.Pago;
import cl.duoc.campuscafe.pago_service.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {
    private final PagoRepository repository;

    @GetMapping
    public List<Pago> listar() { return repository.findAll(); }

    @PostMapping
    public Pago procesarPago(@RequestBody Pago pago) { return repository.save(pago); }
}