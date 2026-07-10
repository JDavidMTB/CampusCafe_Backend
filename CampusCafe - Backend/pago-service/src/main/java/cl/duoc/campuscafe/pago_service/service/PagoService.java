package cl.duoc.campuscafe.pago_service.service;

import cl.duoc.campuscafe.pago_service.entity.Pago;
import cl.duoc.campuscafe.pago_service.repository.PagoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public Pago registrarPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago obtenerPorId(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: El pago con ID " + id + " no existe."));
    }

    public List<Pago> obtenerTodos() {
        return pagoRepository.findAll();
    }
}