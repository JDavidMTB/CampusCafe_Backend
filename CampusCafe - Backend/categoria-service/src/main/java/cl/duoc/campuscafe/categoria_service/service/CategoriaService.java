package cl.duoc.campuscafe.categoria_service.service;

import cl.duoc.campuscafe.categoria_service.entity.Categoria;
import cl.duoc.campuscafe.categoria_service.repository.CategoriaRepository;
import cl.duoc.campuscafe.categoria_service.exception.CategoriaNoEncontradaException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private static final Logger log = LoggerFactory.getLogger(CategoriaService.class);
    private final CategoriaRepository repository;

    public List<Categoria> obtenerTodas() {
        log.info("Consultando todas las categorías");
        return repository.findAll();
    }

    public Categoria guardar(Categoria categoria) {
        log.info("Guardando categoría: {}", categoria.getNombre());
        return repository.save(categoria);
    }

    public Categoria obtenerPorId(Long id) {
        log.info("Buscando categoría ID {}", id);
        return repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Categoría no encontrada ID {}", id);
                    return new CategoriaNoEncontradaException(id);
                });
    }
}
