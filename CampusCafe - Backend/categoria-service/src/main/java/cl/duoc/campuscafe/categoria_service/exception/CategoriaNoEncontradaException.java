package cl.duoc.campuscafe.categoria_service.exception;

public class CategoriaNoEncontradaException extends RuntimeException {
    public CategoriaNoEncontradaException(Long id) {
        super("Categoría no encontrada con ID: " + id);
    }
}
