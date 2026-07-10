package cl.duoc.campuscafe.categoria_service.service;

import cl.duoc.campuscafe.categoria_service.entity.Categoria;
import cl.duoc.campuscafe.categoria_service.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // 1. Método para el POST del controlador (service.guardar)
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // 2. Método para el GET por ID del controlador (service.obtenerPorId)
    public Categoria obtenerPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: La categoria con ID " + id + " no existe."));
    }

    // 3. Método para el GET general del controlador (service.obtenerTodas)
    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }
}