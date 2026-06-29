package cl.duoc.campuscafe.producto_service.exception;

public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(Long id) {
        super("Producto no encontrado con ID: " + id);
    }
}