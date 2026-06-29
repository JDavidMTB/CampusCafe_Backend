package cl.duoc.campuscafe.producto_service.service;

import cl.duoc.campuscafe.producto_service.entity.Producto;
import cl.duoc.campuscafe.producto_service.repository.ProductoRepository;
import cl.duoc.campuscafe.producto_service.exception.ProductoNoEncontradoException;
import cl.duoc.campuscafe.producto_service.dto.CategoriaRemoteDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private static final Logger log = LoggerFactory.getLogger(ProductoService.class);
    private final ProductoRepository repository;
    private final RestTemplate restTemplate; // Inyectamos el cliente HTTP

    public List<Producto> obtenerTodos() {
        log.info("Consultando todos los productos");
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
        log.info("Validando categoría remota ID: {}", producto.getCategoriaId());

        // URL del microservicio vecino
        String url = "http://localhost:8082/api/categorias/" + producto.getCategoriaId();

        try {
            // Hacemos la petición remota vía HTTP GET
            CategoriaRemoteDTO cat = restTemplate.getForObject(url, CategoriaRemoteDTO.class);
            log.info("Categoría remota válida detectada: {}", cat.getNombre());

        } catch (HttpClientErrorException.NotFound e) {
            log.error("Error en comunicación remota: La categoría {} no existe en el puerto 8082", producto.getCategoriaId());
            throw new RuntimeException("No se puede crear el producto: La categoría asignada no existe.");
        } catch (Exception e) {
            log.error("Error crítico al conectar con categoria-service: {}", e.getMessage());
            throw new RuntimeException("Servicio de categorías no disponible temporalmente.");
        }

        log.info("Guardando producto: {}", producto.getNombre());
        return repository.save(producto);
    }

    public Producto obtenerPorId(Long id) {
        log.info("Buscando producto ID {}", id);
        return repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Producto no encontrado ID {}", id);
                    return new ProductoNoEncontradoException(id);
                });
    }

    public Producto actualizar(Long id, Producto productoActualizado) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));

        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setStock(productoActualizado.getStock());
        producto.setCategoriaId(productoActualizado.getCategoriaId()); // <-- Asegúrate de incluir esta línea también

        return repository.save(producto);
    }
}
