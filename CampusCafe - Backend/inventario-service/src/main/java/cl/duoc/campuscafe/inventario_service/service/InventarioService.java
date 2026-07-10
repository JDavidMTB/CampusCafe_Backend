package cl.duoc.campuscafe.inventario_service.service;

import cl.duoc.campuscafe.inventario_service.entity.Inventario;
import cl.duoc.campuscafe.inventario_service.repository.InventarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioService(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public Inventario actualizarStock(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario obtenerPorId(Long id) {
        return inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Registro de inventario con ID " + id + " no existe."));
    }

    public List<Inventario> obtenerTodo() {
        return inventarioRepository.findAll();
    }
}
